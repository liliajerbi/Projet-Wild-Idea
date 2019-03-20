package com.example.wildeas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import com.example.wildeas.adapter.AdaptersIdeasList;
import com.example.wildeas.models.Adders;
import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuhome, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_aboutUs:
                Intent gotoAboutUs = new Intent(Home.this, AboutUs.class);
                startActivity(gotoAboutUs);
                return true;
            case R.id.action_deco:
                AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                builder.setTitle(R.string.caution);
                builder.setMessage(R.string.messagequit);
                builder.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gotoMain = new Intent(Home.this, MainActivity.class);
                        startActivity(gotoMain);
                    }
                });
                builder.setNegativeButton(R.string.no, null);
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView texthello = findViewById(R.id.textHello);
        SharedPreferences sharedpref = Home.this.getSharedPreferences("com.example.wildeas", Context.MODE_PRIVATE);
        texthello.setText(String.format("Welcome %s !", sharedpref.getString("Login", "")));

        Spinner spinnercategories = findViewById(R.id.spinner);
        List<String> categories = new ArrayList<>();
        categories.add("Cinema");
        categories.add("Serie");
        categories.add("Anime");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, categories);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercategories.setAdapter(adapter);

        ImageButton buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoaddPage = new Intent(Home.this, add_page.class);
                startActivity(gotoaddPage);
            }
        });

        Intent added = getIntent();
        String myCategory = added.getStringExtra("categorieText");
        String myTitle = added.getStringExtra("titleText");
        String myDate = added.getStringExtra("dateText");
        String myDescripiton = added.getStringExtra("descripitonText");
        String mymnemonic = added.getStringExtra("mnemonic");
        String mImageUrl = added.getStringExtra("imageIcon");
        String category = added.getStringExtra("categorie");

        //Liste pour film
        final List<Adders> filmList = new ArrayList<>();

        filmList.add(new Adders("\n" +
                "Idiocracy\n","Joe Bowers, l'Américain moyen par excellence, est choisi par le Pentagone comme cobaye d'un programme d'hibernation, qui va mal tourner. Il se réveille 500 ans plus tard et découvre que le niveau intellectuel de l'espèce humaine a radicalement baissé et qu'il est l'homme le plus brillant sur la planète... ", "  25 avril 2007 ", "idiocracy"));
        filmList.add(new Adders("\n" +
                "L'Arnacoeur\n", "Votre fille sort avec un sale type ? Votre soeur s'est enlisée dans une relation passionnelle destructrice ? Aujourd'hui, il existe une solution radicale, elle s'appelle Alex. Son métier : briseur de couple professionnel.", " 17 mars 2010","arnacoeur"));
        filmList.add(new Adders("\n" +
                "Inception\n", "Dom Cobb est un voleur expérimenté – le meilleur qui soit dans l’art périlleux de l’extraction : sa spécialité consiste à s’approprier les secrets les plus précieux d’un individu, enfouis au plus profond de son subconscient, pendant qu’il rêve et que son esprit est particulièrement vulnérable. ", " 21/07/2010","inception"));

       if (category!=null && category.equals("Film")) {
           filmList.add(new Adders(myTitle, myDescripiton, myDate, mImageUrl));
        }


        //Liste pour serie
        final List<Adders> serieList = new ArrayList<>();

        serieList.add(new Adders("Peaky Blinders", "En 1919, à Birmingham, soldats, révolutionnaires politiques et criminels combattent pour se faire une place dans le paysage industriel de l'après-Guerre. Le Parlement s'attend à une violente révolte, et Winston Churchill mobilise des forces spéciales pour contenir les menaces. La famille Shelby compte parmi les membres les plus redoutables. ", "Depuis 2013","peaky"));
        serieList.add(new Adders("Game of thrones", "Il y a très longtemps, à une époque oubliée, une force a détruit l'équilibre des saisons. Dans un pays où l'été peut durer plusieurs années et l'hiver toute une vie, des forces sinistres et surnaturelles se pressent aux portes du Royaume des Sept Couronnes. ","Depuis 2011", "got"));
        serieList.add(new Adders("House of Cards", "Frank Underwood, homme politique rusé et vieux briscard de Washington, est prêt à tout pour conquérir le poste \"suprême\"...","2013 - 2018", "houseofcards"));

        if (category!=null && category.equals("Serie")){
        serieList.add(new Adders(myTitle, myDescripiton,myDate,mImageUrl));
       }

        //Liste pour animes
        final List<Adders> animeList = new ArrayList<>();

        animeList.add(new Adders("Death Note"," Light Yagami, un jeune étudiant surdoué, ramasse un jour le \"Death Note\", un carnet tenu auparavant par un shinigami (Dieu de la mort), Ryuk, qui apparemment s'ennuyait dans son monde.\n" +
                "\n" +
                "Il suffit d'écrire le nom d'une personne dans ce carnet, et celle-ci meurt (selon certaines conditions que le shinigami expliquera à Light lors de leur rencontre).", "04/10/2006","deathnote"));
        animeList.add(new Adders("\n" +
                "Nana", "Nana Komatsu, une jeune étudiante, décide de quitter sa ville natale pour partir rejoindre son petit ami Shôji, qui étudie dans une école d'art à Tokyo. ", "05/04/2006 ","nana"));
        animeList.add(new Adders("Yakusoku no Neverland", "Emma, Norman et Ray coulent des jours heureux à l'orphelinat Grace Field House. Entourés de leurs petits frères et sœurs, ils s'épanouissent sous l'attention pleine de tendresse de « Maman », qu'ils considèrent comme leur véritable mère. Mais tout bascule le soir où ils découvrent l'abominable réalité qui se cache derrière la façade de leur vie paisible ! Ils doivent s'échapper, c'est une question de vie ou de mort !", "09/01/2019","neverland"));
       if (category!=null && category.equals("Anime")){
        animeList.add(new Adders(myTitle,myDescripiton, myDate, mImageUrl));}


        //Spinner

       spinnercategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               switch (position) {
                   case 0 :
                       ListView ideasListView = findViewById(R.id.idea_view_list);
                       ideasListView.setAdapter(new AdaptersIdeasList(Home.this, filmList));
                       break;
                   case 1 :
                        ideasListView = findViewById(R.id.idea_view_list);
                       ideasListView.setAdapter(new AdaptersIdeasList(Home.this, serieList));
                       break;
                   case 2 :
                       ideasListView = findViewById(R.id.idea_view_list);
                       ideasListView.setAdapter(new AdaptersIdeasList(Home.this, animeList));
                       break;
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

    }

}
