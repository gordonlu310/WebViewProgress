package com.gordonlu.webviewerprogress;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.webkit.WebView;
import android.view.View;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.webkit.WebChromeClient;

@DesignerComponent(
        version = 1,
        description = "A non-visible extension that detects the progress loading of the WebViewer.",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "https://docs.google.com/drawings/d/e/2PACX-1vQCI87PHLBF0jb8QWyYmIRQSjjNW3EFXf-qpsWCvBYkUQ9vEgPAB8SpxcMpblxNpbIYrjCjLrRLIU2c/pub?w=16&h=16")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class WebViewProgress extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;

    public WebViewProgress(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction(description = "Listens to all web viewer loading changes and fires the ProgressChanged event when it changes.")
    public void ApplyProgressChangedListener(AndroidViewComponent webViewer){
        View view = webViewer.getView();
        WebView wv = (WebView) view;
        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                ProgressChanged(progress); 
    }
                    });
    }

    @SimpleEvent(description = "This event is fired when the progress of the WebViewer has changed.")
    public void ProgressChanged(int progress){
        EventDispatcher.dispatchEvent(this, "ProgressChanged", progress);
    }
}