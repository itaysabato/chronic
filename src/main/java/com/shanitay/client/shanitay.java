package com.shanitay.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class shanitay implements EntryPoint {

  public void onModuleLoad() {
      try {
          RootPanel.get().add(new MyNewWidget());
      }
      catch (Throwable e) {
        Log.error("Failed to load module.", e);
      }
  }
}
