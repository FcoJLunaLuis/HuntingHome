package mx.com.yh.huntinghome.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.vistas.FragmentHome;
import mx.com.yh.huntinghome.vistas.ViewPagerAdapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {
    TabLayout tab;
    private int[] tabIcon={
            R.drawable.ic_home_black,R.drawable.ic_mail_black,
            R.drawable.ic_person_black
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewPager viewP=(ViewPager)findViewById(R.id.viewPagerHome);
        loadViewPager(viewP);
        tab=(TabLayout)findViewById(R.id.tabsHome);
        tab.setupWithViewPager(viewP);
        tabIcons();
        iconColor(tab.getTabAt(0),"#000000");
        eventoTab();
    }

    private void loadViewPager(ViewPager viewPager){
        ViewPagerAdapter vpa=new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addFragment(homeNewInstance("Residencias"));
        vpa.addFragment(listaMensajesnewInstance("Mensajes"));
        vpa.addFragment(perfilUsrNewInstance("Perfil"));
        viewPager.setAdapter(vpa);
    }

    private void tabIcons(){
        for(int i=0;i<tabIcon.length;i++){
            tab.getTabAt(i).setIcon(tabIcon[i]);
        }
    }

    private void eventoTab(){
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                iconColor(tab,"#000000");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                iconColor(tab,"#e0e0e0");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void iconColor(TabLayout.Tab tab,String color){
        tab.getIcon().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
    }

    private FragmentHome homeNewInstance(String title){
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        FragmentHome fh=new FragmentHome();
        fh.setArguments(bundle);
        return fh;
    }
    private PerfilUsr perfilUsrNewInstance(String title){
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        PerfilUsr perUsr=new PerfilUsr();
        perUsr.setArguments(bundle);
        return perUsr;
    }
    private ListaMensajes listaMensajesnewInstance(String title){
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        ListaMensajes listMen=new ListaMensajes();
        listMen.setArguments(bundle);
        return listMen;
    }
}