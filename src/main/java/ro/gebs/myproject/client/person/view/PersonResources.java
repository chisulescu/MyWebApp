package ro.gebs.myproject.client.person.view;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface PersonResources extends ClientBundle {

    public interface MyCss extends CssResource{

        String blackText();

        String background();

        String schimbaButton();
    }


    @Source("Person.css")
    MyCss style();

}
