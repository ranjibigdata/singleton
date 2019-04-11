package com.sunlife;

public class LazyDoubleLockCheckSingleton{

    private static volatile LazyDoubleLockCheckSingleton singletonInstance = null;

    //making constructor as private to prevent access to outsiders

    private LazyDoubleLockCheckSingleton() {

    }

    /*

    Scenarios covered:
    ==================

    1) Lazy initialization - Object is created as and when it is required as opposed to classloading itself.

    2) Double checked locking - Avoid creation of objects by multiple threads.

    --> Thread t1 checks the condition if(singletonInstance==null)
    and it is true for first time so it enters synchronized block
    and there again it checks the condition if(singletonInstance==null)
    and this is also true so creates the object.

    --> Now thread t2 enters the method getInstance() and
    assume it has executed if(singletonInstance==null) condition before the thread t1
    executes the object creation logic then t2 also waits to enter the synchronized block.

    --> After thread t1 comes out of synchronized block thread t2 enters the same block ,
    but we have again the if condition there if(singletonInstance==null) but thread t1
    already created an object, it makes the condition to be false and stop the execution
    further and returns the same instance

    */

    public static LazyDoubleLockCheckSingleton getInstance(){

        if(singletonInstance==null){
            synchronized (LazyDoubleLockCheckSingleton.class) {
                if(singletonInstance ==null){
                    singletonInstance = new LazyDoubleLockCheckSingleton();
                }
            }
        }
        return singletonInstance;
    }
}
