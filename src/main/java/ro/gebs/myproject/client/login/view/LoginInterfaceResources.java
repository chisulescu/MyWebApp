package ro.gebs.myproject.client.login.view;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface LoginInterfaceResources extends ClientBundle {

    public interface MyCss extends CssResource{

        String blackText();

        String redText();

        String loginButton();

        String regsiterButton();

        String box();

        String background();
    }

    @Source("LoginInterface.css")
    MyCss style();

}
