package com.example.catomatic;

import com.example.catomatic.dummy.DummyContent;
import com.example.catomatic.entity.Cat;
import com.example.catomatic.network.CatService;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A fragment representing a single Cat detail screen.
 * This fragment is either contained in a {@link CatListActivity}
 * in two-pane mode (on tablets) or a {@link CatDetailActivity}
 * on handsets.
 */
public class CatDetailFragment extends Fragment {
    private static final String TAG = CatDetailFragment.class.getSimpleName();

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;
    private Cat cat;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CatDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            cat = getArguments().getParcelable("cat");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_cat_detail_new, container, false);

        if (cat != null) {
            ((TextView) rootView.findViewById(R.id.name)).setText(cat.name);
            ((TextView) rootView.findViewById(R.id.age)).setText(Integer.toString(cat.ageInMonths));
        }

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://mostlygeeks.com:5000")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        CatService catService = restAdapter.create(CatService.class);
        //CatService catService = new MockCatService();

        // TODO: Add authentication token header.

        catService.cat(cat.id, new Callback<Cat>() {
            @Override
            public void success(Cat cat, Response response) {
                ((TextView) rootView.findViewById(R.id.long_description))
                        .setText(cat.longDescription);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.toString());
            }
        });

        return rootView;
    }
}
