package ro.gebs.myproject.client.controller;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TabPanel;


public class Controller{



    protected void onAtach(){


       TabPanel tabPanel = new TabPanel();

       SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();


//
//        splitLayoutPanel.addDomHandler(new SelectionHandler<Integer>() {
//            @Override
//            public void onSelection(SelectionEvent<Integer> event) {
//            /* add a token to history containing pageIndex
//             History class will change the URL of application
//             by appending the token to it.
//            */
//                History.newItem("pageIndex" + event.getSelectedItem());
//            }
//        });

//        History.addValueChangeHandler(new ValueChangeHandler<String>() {
//            @Override
//            public void onValueChange(ValueChangeEvent<String> event) {
//                String historyToken = event.getValue();
//
//            }
//        };

    }



}
