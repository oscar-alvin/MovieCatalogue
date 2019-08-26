package dicoding.com.moviecatalogue;

import java.util.ArrayList;
import java.util.List;
import dicoding.com.moviecatalogue.model.movie;

public class InitMovie {
    private List<movie> movieList = new ArrayList<>();

    public InitMovie(){
        movie m1 = new movie();
        m1.setIdMovie(1);
        m1.setTitleMovie("A Star Is Born");
        m1.setGenreMovie("Drama, Romance, Music");
        m1.setDurasiMovie(135);
        m1.setTahunMovie(2018);
        m1.setDetailMovie("Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.");
        m1.setPosterMovie(R.drawable.poster_a_star);
        m1.setArtisName(new String[]{"Lady Gaga","Bradley Cooper", "Sam Elliot"});
        m1.setArtisPhoto(new int[]{R.drawable.lady_gaga,R.drawable.bradley,R.drawable.sam_elliott });
        m1.setPoint(75);
        m1.setReleaseMovie("5-Oct-18");

		movie m2 = new movie();
        m2.setIdMovie(2);
        m2.setTitleMovie("Aquaman");
        m2.setGenreMovie("Action, Adventure, Fancasy");
        m2.setDurasiMovie(144);
        m2.setTahunMovie(2018);
        m2.setDetailMovie("Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.");
        m2.setPosterMovie(R.drawable.poster_aquaman);
        m2.setArtisName(new String[]{"Jason Momoa","Amber Heart", "Willem Dafoe"});
        m2.setArtisPhoto(new int[]{R.drawable.jason,R.drawable.amber,R.drawable.willem });
        m2.setPoint(68);
        m2.setReleaseMovie("21-Dec-18");

		movie m3 = new movie();
        m3.setIdMovie(3);
        m3.setTitleMovie("Avenger Infinity");
        m3.setGenreMovie("Action, Adventure, Science Fiction");
        m3.setDurasiMovie(149);
        m3.setTahunMovie(2018);
        m3.setDetailMovie("As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.");
        m3.setPosterMovie(R.drawable.poster_avengerinfinity);
        m3.setArtisName(new String[]{"Robert Downney Jr", "Chris Hemsworth", "Chris Evans"});
        m3.setArtisPhoto(new int[]{R.drawable.robert_djr,R.drawable.chris_hem,R.drawable.chris_evans });
        m3.setPoint(83);
        m3.setReleaseMovie("23-Apr-18");
		
		movie m4 = new movie();
        m4.setIdMovie(4);
        m4.setTitleMovie("Bird Box");
        m4.setGenreMovie("Thriller, Drama");
        m4.setDurasiMovie(124);
        m4.setTahunMovie(2018);
        m4.setDetailMovie("Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.");
        m4.setPosterMovie(R.drawable.poster_birdbox);
        m4.setArtisName(new String[]{"Sandra Bullock", "Trevante Rhodes", "John Malkovich"});
        m4.setArtisPhoto(new int[]{R.drawable.sandra_bullock,R.drawable.trevante,R.drawable.jon_mal });
        m4.setPoint(70);
        m4.setReleaseMovie("12-Nov-18");
		
		movie m5 = new movie();
        m5.setIdMovie(5);
        m5.setTitleMovie("Bohemian Rhapsody");
        m5.setGenreMovie("Drama, Music");
        m5.setDurasiMovie(135);
        m5.setTahunMovie(2018);
        m5.setDetailMovie("Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.");
        m5.setPosterMovie(R.drawable.poster_bohemian);
        m5.setArtisName(new String[]{"Rami Malek", "Gwilym Lee", "Ben Hardy"});
        m5.setArtisPhoto(new int[]{R.drawable.rami_malek,R.drawable.gwilym,R.drawable.ben_hardy });
        m5.setPoint(81);
        m5.setReleaseMovie("30-Oct-18");
		
		movie m6 = new movie();
        m6.setIdMovie(6);
        m6.setTitleMovie("Bumblebee");
        m6.setGenreMovie("Action, Adventure, Science Fiction");
        m6.setDurasiMovie(114);
        m6.setTahunMovie(2018);
        m6.setDetailMovie("On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.");
        m6.setPosterMovie(R.drawable.poster_bumblebee);
        m6.setArtisName(new String[]{"Hailee Steinfeld","Jorge Lendeborg Jr.","John Cena"});
        m6.setArtisPhoto(new int[]{R.drawable.hailee,R.drawable.jorge_lend,R.drawable.john_cena });
        m6.setPoint(65);
        m6.setReleaseMovie("21-Dec-18");
		
		movie m7 = new movie();
        m7.setIdMovie(7);
        m7.setTitleMovie("Creed II");
        m7.setGenreMovie("Drama");
        m7.setDurasiMovie(130);
        m7.setTahunMovie(2018);
        m7.setDetailMovie("Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.");
        m7.setPosterMovie(R.drawable.poster_creed);
        m7.setArtisName(new String[]{"Michael B. Jordan","Sylvester Stallone","Dolp Lundgren"});
        m7.setArtisPhoto(new int[]{R.drawable.michael_bj,R.drawable.sylvester,R.drawable.dolph });
        m7.setPoint(67);
        m7.setReleaseMovie("14-Nov-18");
		
		movie m8 = new movie();
        m8.setIdMovie(8);
        m8.setTitleMovie("Once Upon a Deadpool");
        m8.setGenreMovie("Comedy Action");
        m8.setDurasiMovie(117);
        m8.setTahunMovie(2018);
        m8.setDetailMovie("A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.");
        m8.setPosterMovie(R.drawable.poster_deadpool);
        m8.setArtisName(new String[]{"Ryan Reynolds","Fred Savage","Josh Brolin"});
        m8.setArtisPhoto(new int[]{R.drawable.ryan_rey,R.drawable.fred,R.drawable.josh });
        m8.setPoint(69);
        m8.setReleaseMovie("11-Dec-18");
		
		movie m9 = new movie();
        m9.setIdMovie(9);
        m9.setTitleMovie("How to Train Your Dragon: The Hidden Wold");
        m9.setGenreMovie("Animation, Family, Adventure");
        m9.setDurasiMovie(135);
        m9.setTahunMovie(2019);
        m9.setDetailMovie("As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.");
        m9.setPosterMovie(R.drawable.poster_dragon);
        m9.setArtisName(new String[]{"Jay Baruchel","America Ferrera","F. Murray Abraham"});
        m9.setArtisPhoto(new int[]{R.drawable.jay,R.drawable.america,R.drawable.murray});
        m9.setPoint(77);
        m9.setReleaseMovie("22-Feb-19");

        movie m10 = new movie();
        m10.setIdMovie(10);
        m10.setTitleMovie("Venom");
        m10.setGenreMovie("Science Fiction, Action");
        m10.setDurasiMovie(112);
        m10.setTahunMovie(2018);
        m10.setDetailMovie("Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.");
        m10.setPosterMovie(R.drawable.poster_venom);
        m10.setArtisName(new String[]{"Tom Hardy","Michelle Williams","Riz Ahmed"});
        m10.setArtisPhoto(new int[]{R.drawable.tom_hardy,R.drawable.michelle,R.drawable.riz });
        m10.setPoint(66);
        m10.setReleaseMovie("1-Oct-18");
		
		movie m11 = new movie();
        m11.setIdMovie(11);
        m11.setTitleMovie("Glass");
        m11.setGenreMovie("Thriller, Drama, Science Fiction");
        m11.setDurasiMovie(129);
        m11.setTahunMovie(2019);
        m11.setDetailMovie("In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.");
        m11.setPosterMovie(R.drawable.poster_glass);
        m11.setArtisName(new String[]{"James McAvoy","Bruce Wilis","Anya Taylor-Joy"});
        m11.setArtisPhoto(new int[]{R.drawable.james_mcavoy,R.drawable.bruce,R.drawable.anya });
        m11.setPoint(65);
        m11.setReleaseMovie("18-Jan-19");
		
		movie m12 = new movie();
        m12.setIdMovie(12);
        m12.setTitleMovie("Hunter Killer");
        m12.setGenreMovie("Action, Thriller");
        m12.setDurasiMovie(122);
        m12.setTahunMovie(2018);
        m12.setDetailMovie("Captain Glass of the USS Arkansas discovers that a coup d'état is taking place in Russia, so he and his crew join an elite group working on the ground to prevent a war.");
        m12.setPosterMovie(R.drawable.poster_hunterkiller);
        m12.setArtisName(new String[]{"Gerard Butler","Gary Oldman","Toby Stephens"});
        m12.setArtisPhoto(new int[]{R.drawable.gerard,R.drawable.gary,R.drawable.toby});
        m12.setPoint(63);
        m12.setReleaseMovie("26-Oct-18");
		
		movie m13 = new movie();
        m13.setIdMovie(13);
        m13.setTitleMovie("Mary Poppins Returns");
        m13.setGenreMovie("Fantasy, Family, Comedy");
        m13.setDurasiMovie(131);
        m13.setTahunMovie(2018);
        m13.setDetailMovie("In Depression-era London, a now-grown Jane and Michael Banks, along with Michael's three children, are visited by the enigmatic Mary Poppins following a personal loss. Through her unique magical skills, and with the aid of her friend Jack, she helps the family rediscover the joy and wonder missing in their lives.");
        m13.setPosterMovie(R.drawable.poster_marrypopins);
        m13.setArtisName(new String[]{"Emily Blunt","Lin-Manuel Miranda","Ben Whishaw"});
        m13.setArtisPhoto(new int[]{R.drawable.emily,R.drawable.lin_man,R.drawable.ben });
        m13.setPoint(66);
        m13.setReleaseMovie("29-Nov-18");
		
		movie m14 = new movie();
        m14.setIdMovie(14);
        m14.setTitleMovie("Mortal Engine");
        m14.setGenreMovie("Adventure, Fantasy");
        m14.setDurasiMovie(129);
        m14.setTahunMovie(2018);
        m14.setDetailMovie("Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.");
        m14.setPosterMovie(R.drawable.poster_mortalengine);
        m14.setArtisName(new String[]{"Hera Hilmar","Robert Sheehan","Hugo Weaving"});
        m14.setArtisPhoto(new int[]{R.drawable.hera,R.drawable.robert,R.drawable.hugo });
        m14.setPoint(60);
        m14.setReleaseMovie("14-Dec-18");
		
		movie m15 = new movie();
        m15.setIdMovie(15);
        m15.setTitleMovie("Preman Pensiun");
        m15.setGenreMovie("Comedy");
        m15.setDurasiMovie(45);
        m15.setTahunMovie(2015);
        m15.setDetailMovie("Bahar, the leader of a group of thugs who control the region, covering markets, terminals and streets, after the death of his wife declared retirement. The statement just delivered on his right hand, Obet. The reason, before he died, his wife said to be waiting for him in heaven. Bahar bepikir, that if he continues to \"go on like this\", is not likely to get there. \nBahar decision can not be accepted by Obet. Therefore, his retirement Bahar will cause the destruction of the establishment of their power, making small groups under them will be scattered, stand alone. In business, this would only be detrimental Obet Bahar right hand and do not have a group.\nBahar retirement are not \"announced\" was used by Obet to take power and \"quota\" for Bahar until then all the action unfold and cause chaos. The leader of a small group; Komar (thugs market), Jamal (thugs terminal) and Herman (street thugs) vied for power. Bahar was then dropped back to tidy state.\nThe story also spiced heartbreaking story of the girl who was almost canceled dipersunting Bahar boyfriend just because he's a thug.");
        m15.setPosterMovie(R.drawable.poster_preman);
        m15.setArtisName(new String[]{"Didi Petet","Epy Kusnandar"});
        m15.setArtisPhoto(new int[]{R.drawable.didi_petet,R.drawable.epy_kusnandar });
        m15.setPoint(78);
        m15.setReleaseMovie("22-Dec-15");
		
        movieList.add(m1);
		movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);
        movieList.add(m5);
        movieList.add(m6);
        movieList.add(m7);
        movieList.add(m8);
        movieList.add(m9);
        movieList.add(m10);
        movieList.add(m11);
        movieList.add(m12);
        movieList.add(m13);
        movieList.add(m14);
        movieList.add(m15);
    }
    public List<movie> getAll(){
        return movieList;
    }
}
