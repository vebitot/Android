// IRemoteService.aidl
package learn.example.vebitot.sharedservice;
/**
 * Created by vebitot on 04-12-2015.
 * An AIDL service definition demonstrating usage of it.
 */
interface IRemoteService {

/**
* Generates a random integer between 0-10000
*/
    int getRandomId();
/**
*   Returns the PID of the remote process
*/
    int getPID();
}
