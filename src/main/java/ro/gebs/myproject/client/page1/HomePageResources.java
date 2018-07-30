package ro.gebs.myproject.client.page1;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import ro.gebs.myproject.client.main.view.MainGuiResources;

public interface HomePageResources {

    public interface MyCss extends CssResource {

        String blackText();

        String redText();
    }

    @ClientBundle.Source("HomePage.css")
    MyCss style();
}
