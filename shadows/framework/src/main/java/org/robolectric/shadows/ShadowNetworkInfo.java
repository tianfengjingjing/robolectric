package org.robolectric.shadows;

import android.net.NetworkInfo;
import org.robolectric.Shadows;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadow.api.Shadow;

@Implements(NetworkInfo.class)
public class ShadowNetworkInfo {
  private boolean isAvailable;
  private boolean isConnected;
  private int connectionType;
  private int connectionSubType;
  private NetworkInfo.DetailedState detailedState;

  public static void __staticInitializer__() {
  }

  public static NetworkInfo newInstance(NetworkInfo.DetailedState detailedState, int type, int subType, boolean isAvailable, boolean isConnected) {
    NetworkInfo networkInfo = Shadow.newInstanceOf(NetworkInfo.class);
    final ShadowNetworkInfo info = Shadows.shadowOf(networkInfo);
    info.setConnectionType(type);
    info.setSubType(subType);
    info.setDetailedState(detailedState);
    info.setAvailableStatus(isAvailable);
    info.setConnectionStatus(isConnected);
    return networkInfo;
  }

  @Implementation
  protected boolean isConnected() {
    return isConnected;
  }

  @Implementation
  protected boolean isConnectedOrConnecting() {
    return isConnected;
  }

  @Implementation
  protected NetworkInfo.State getState() {
    return isConnected ? NetworkInfo.State.CONNECTED :
      NetworkInfo.State.DISCONNECTED;
  }

  @Implementation
  protected NetworkInfo.DetailedState getDetailedState() {
    return detailedState;
  }

  @Implementation
  protected int getType(){
    return connectionType;
  }

  @Implementation
  protected int getSubtype() {
    return connectionSubType;
  }

  @Implementation
  protected boolean isAvailable() {
    return isAvailable;
  }

  /**
   * Sets up the return value of {@link #isAvailable()}.
   *
   * @param isAvailable the value that {@link #isAvailable()} will return.
   */
  public void setAvailableStatus(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  /**
   * Sets up the return value of {@link #isConnectedOrConnecting()} and {@link #isConnected()}.
   *
   * @param isConnected the value that {@link #isConnectedOrConnecting()} and {@link #isConnected()} will return.
   */
  public void setConnectionStatus(boolean isConnected) {
    this.isConnected = isConnected;
  }

  /**
   * Sets up the return value of {@link #getType()}.
   *
   * @param connectionType the value that {@link #getType()} will return.
   */
  public void setConnectionType(int connectionType){
    this.connectionType = connectionType;
  }

  public void setSubType(int subType) {
    this.connectionSubType = subType;
  }

  public void setDetailedState(NetworkInfo.DetailedState detailedState) {
    this.detailedState = detailedState;
  }
}