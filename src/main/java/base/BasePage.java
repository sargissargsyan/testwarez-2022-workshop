package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.io.IOException;

import static base.DriverHelper.getDriver;

/**
 * @author Sargis Sargsyan on 8/18/22
 * @project testwarez2022
 */
public abstract class  BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected static final String BASE_URL = "http://localhost:9000";

    public BasePage() {
    }

    @Override
    protected void load() {
        getDriver().get(BASE_URL + getUrl());
    }

    protected T openPage() {
        PageFactory.initElements(getDriver(), this);
        load();
        return get();
    }

    public abstract T open();

    public abstract T init();

    protected T initPage() {
        PageFactory.initElements(getDriver(), this);
        return get();
    }

    public <T extends BasePage> T initElements() {
        PageFactory.initElements(getDriver(), this);
        return (T) this;
    }


    public abstract String getUrl();



}
