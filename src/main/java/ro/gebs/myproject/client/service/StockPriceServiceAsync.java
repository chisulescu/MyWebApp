package ro.gebs.myproject.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StockPriceServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see ro.gebs.myproject.client.service.StockPriceService
     */
    void getPrices( java.lang.String[] symbols, AsyncCallback<ro.gebs.myproject.shared.stock.StockPrice[]> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static StockPriceServiceAsync instance;

        public static final StockPriceServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (StockPriceServiceAsync) GWT.create( StockPriceService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
