package movieadmin.indoscience.testfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentChild.OnListener {

    private  Fragment fragment;
    private static final String TAG = "MainActivity";
    String results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            fragment = new FragmentHome();
            fragmentShow(fragment,"Home");
        }


    }


    private void fragmentShow(Fragment fragmentParam, String title){
        setTitle(title);
        if (fragmentParam != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragmentLayout,fragmentParam,title);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            if (!title.equals("Home")){
                ft.addToBackStack(null);
            }
            ft.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: start");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",results);
        Log.d(TAG, "onSaveInstanceState: start");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void OnResult(String result) {
        results = result;
    }
}
