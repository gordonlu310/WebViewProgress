package com.gordonlu.webviewerprogressfr;

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

public class WebViewProgressFr extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;

    public WebViewProgressFr(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction(description = "Demarre le suivi de toutes les modifications de progression pour Afficheur Web et appelle l'evenement ProgressChanged si necessaire.")
    public void SuivreLaProgression(AndroidViewComponent afficheurWeb){
        View view = afficheurWeb.getView();
        WebView wv = (WebView) view;
        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                ProgressionModifiee(progress); 
    }
                    });
    }

    @SimpleEvent(description = "Cet evenement se produit lorsque la progression de Afficheur Web a change.")
    public void ProgressionModifiee(int progres){
        EventDispatcher.dispatchEvent(this, "ProgressionModifiee", progres);
    }
}