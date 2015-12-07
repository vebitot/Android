// IRemoteService.aidl
/**
 * Created by vebitot on 04-12-2015.
 * An AIDL service definition demonstrating usage of it.
 */

package vebitot.learn.remoteservicetest;

interface IRemoteMathService {

/**
* Generates a random integer between 0-10000
*/
    int getRandomId();
/**
*   Returns the PID of the remote process
*/
    int getPID();
}
