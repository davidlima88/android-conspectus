package edu.humber.conspectus;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import edu.humber.conspectus.fragment.BookmarkFragment;
import edu.humber.conspectus.fragment.CategoryDetailFragment;
import edu.humber.conspectus.fragment.CategoryFragment;
import edu.humber.conspectus.fragment.ConceptDetailFragment;
import edu.humber.conspectus.fragment.ConceptFragment;
import edu.humber.conspectus.fragment.EntityDetailFragment;
import edu.humber.conspectus.fragment.EntityFragment;
import edu.humber.conspectus.fragment.KeywordDetailFragment;
import edu.humber.conspectus.fragment.KeywordFragment;
import edu.humber.conspectus.fragment.WebBrowserFragment;
import edu.humber.conspectus.model.Bookmark;
import edu.humber.conspectus.model.Category;
import edu.humber.conspectus.model.Concept;
import edu.humber.conspectus.model.Keyword;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        WebBrowserFragment.OnFragmentInteractionListener,  BookmarkFragment.OnListFragmentInteractionListener,
        CategoryFragment.OnClickCategoryListener,
        ConceptFragment.OnClickConceptListener,
        EntityFragment.OnClickEntityListener,
        KeywordFragment.OnClickKeywordListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        try {
            Fragment fragment = WebBrowserFragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
            setTitle("Conspectus - Web Explorer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Fragment fragment;
        Class fragmentClass;

        fragmentClass = WebBrowserFragment.class;

        if (id == R.id.nav_explorer) {
            fragmentClass = WebBrowserFragment.class;
        } else if (id == R.id.nav_bookmarks) {
            fragmentClass = BookmarkFragment.class;
        } else if (id == R.id.nav_entities) {
            fragmentClass = EntityFragment.class;
        } else if (id == R.id.nav_categories) {
            fragmentClass = CategoryFragment.class;
        } else if (id == R.id.nav_concepts) {
            fragmentClass = ConceptFragment.class;
        } else if (id == R.id.nav_keywords) {
            fragmentClass = KeywordFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
            item.setChecked(true);
            setTitle("Conspectus - " + item.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClickEntityListener(Bookmark item) {
        try {
            EntityDetailFragment fragment = EntityDetailFragment.newInstance(item.getId());
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
            setTitle("Conspectus - " + item.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("toast",item.getId().toString());
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Bookmark item) {

    }

    @Override
    public void onClickCategoryListener(Bookmark item) {
        try {
            CategoryDetailFragment fragment = CategoryDetailFragment.newInstance(item.getId());
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
            setTitle("Conspectus - " + item.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClickKeywordListener(Bookmark item) {
        try {
            KeywordDetailFragment fragment = KeywordDetailFragment.newInstance(item.getId());
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
            setTitle("Conspectus - " + item.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClickConceptListener(final Bookmark item) {
        try {
            ConceptDetailFragment fragment = ConceptDetailFragment.newInstance(item.getId());
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
            setTitle("Conspectus - " + item.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
