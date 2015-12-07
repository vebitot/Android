/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\Android\\Mather\\src\\vebitot\\learn\\remoteservicetest\\IRemoteMathService.aidl
 */
package vebitot.learn.remoteservicetest;
public interface IRemoteMathService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements vebitot.learn.remoteservicetest.IRemoteMathService
{
private static final java.lang.String DESCRIPTOR = "vebitot.learn.remoteservicetest.IRemoteMathService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an vebitot.learn.remoteservicetest.IRemoteMathService interface,
 * generating a proxy if needed.
 */
public static vebitot.learn.remoteservicetest.IRemoteMathService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof vebitot.learn.remoteservicetest.IRemoteMathService))) {
return ((vebitot.learn.remoteservicetest.IRemoteMathService)iin);
}
return new vebitot.learn.remoteservicetest.IRemoteMathService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getRandomId:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getRandomId();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPID:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPID();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements vebitot.learn.remoteservicetest.IRemoteMathService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
* Generates a random integer between 0-10000
*/
@Override public int getRandomId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRandomId, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
*   Returns the PID of the remote process
*/
@Override public int getPID() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPID, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getRandomId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getPID = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
* Generates a random integer between 0-10000
*/
public int getRandomId() throws android.os.RemoteException;
/**
*   Returns the PID of the remote process
*/
public int getPID() throws android.os.RemoteException;
}
