package org.robolectric.shadows;

import android.view.WindowManager;
import android.widget.PopupWindow;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.util.ReflectionHelpers;

import static org.robolectric.shadow.api.Shadow.directlyOn;

@Implements(PopupWindow.class)
public class ShadowPopupWindow {

  @RealObject
  private PopupWindow realPopupWindow;

  @Implementation
  protected void invokePopup(WindowManager.LayoutParams p) {
    ShadowApplication.getInstance().setLatestPopupWindow(realPopupWindow);
    directlyOn(realPopupWindow,
        PopupWindow.class,
        "invokePopup",
        ReflectionHelpers.ClassParameter.from(WindowManager.LayoutParams.class, p));
  }
}