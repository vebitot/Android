package com.vebitot.mcm.androidclient.workers;
/**
 * Interface for getting back the response from an async task to the UI thread
 * @author vebitot
 */
public interface IAsyncResponse {
	public void executionComplete(Object result);
}
