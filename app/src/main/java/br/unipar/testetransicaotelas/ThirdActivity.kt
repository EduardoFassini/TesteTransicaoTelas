package br.unipar.testetransicaotelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class ThirdActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navViewTelas)
        val tabLayout = findViewById<TabLayout>(R.id.tabTelas)
        val btn1 = findViewById<Button>(R.id.btnTela1)
        val btn2 = findViewById<Button>(R.id.btnTela2)

        tabLayout.addTab(tabLayout.newTab().setText("Tela 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tela 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tela 3"))


        // Iniciar Toolbar
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbarTelas)
        setSupportActionBar(toolbar)

        // Configurar ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        btn1.setOnClickListener(){
            val intent = Intent(this@ThirdActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        btn2.setOnClickListener(){
            val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Lidar com cliques nos itens do NavigationView
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tela1 -> {
                    // Lógica para o item "Tela 1"
                    val intent = Intent(this@ThirdActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }

                R.id.tela2 -> {
                    // Lógica para o item "Tela 2"
                    val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
            }
            drawerLayout.closeDrawers() // Fecha o drawer ao selecionar
            true
        }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        // Abrir Activity 1
                        val intent = Intent(this@ThirdActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        startActivity(intent)
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    }

                    1 -> {
                        // Abrir Activity 2
                        val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        startActivity(intent)
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

                    }

                    2 -> {
                        // Abrir Activity 3
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Não precisa de ação aqui
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Não precisa de ação aqui
            }
        })
    }

    override fun onStart() {
        super.onStart()
        val tabLayout = findViewById<TabLayout>(R.id.tabTelas)
        tabLayout.getTabAt(2)?.select()
        navView.setCheckedItem(R.id.tela3)
    }

    // Sincroniza o estado do toggle com as mudanças do drawer
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    // Controla a navegação do botão de volta do sistema com o Drawer
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navView)) {
            drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }

    }

}
