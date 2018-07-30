package ro.gebs.myproject.client.inregistrare.view;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface InregistrareInterfaceResources extends ClientBundle {

    public interface MyCss extends CssResource{

        String blackText();

        String loginButton();


    }

    @Source("InregistrareInterface.css")
    MyCss style();





}
