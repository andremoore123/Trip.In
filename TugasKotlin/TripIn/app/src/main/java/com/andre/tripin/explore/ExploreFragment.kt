package com.andre.tripin.explore

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.tripin.DetailActivity
import com.andre.tripin.R
import com.andre.tripin.adapter.DataItem
import com.andre.tripin.adapter.RecyclerViewAdapter

class ExploreFragment : Fragment(), RecyclerViewAdapter.OnItemClickListener {
    private val list: MutableList<DataItem> = createList()
    private val indoList: MutableList<DataItem> = createIndoList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_explore, container, false)
        val recyclerViewGlobal = view.findViewById<RecyclerView>(R.id.explore_recycler_global)
        recyclerViewGlobal.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecyclerViewAdapter(list, R.layout.places_card, this@ExploreFragment)
        }
        recyclerViewGlobal.setHasFixedSize(true)

        val recyclerViewIndo = view.findViewById<RecyclerView>(R.id.explore_recycler_indonesia)
        recyclerViewIndo.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerViewAdapter(indoList, R.layout.horizontal_card, this@ExploreFragment)
        }

        return view
    }
    fun createList(): MutableList<DataItem>{
        return mutableListOf(
            DataItem(R.drawable.santorini, "Santorini", "Visit Oia, the beautiful pearl on Santorini Island,See what is arguably the world's most famous sunset", "Next to the Parthenon in Athens, the famous blue church domes on Santorini Island are instantly recognizable. Set high above the blue waters of the Aegean Sea, Santorini is a timeless wonder. The cliffs drop down some 300 m, making the towns and buildings seem precariously perched close to the sheer edge. A central lagoon formed when the volcanic caldera collapsed in a massive eruption some 3600 years ago. Today Santorini is a renowned tourist destination. Quaint villages and Mediterranean architecture make for stunning photos. The sunsets are incredible and temperatures remain pleasant even in the high summer months. Well-connected to the rest of Greece, Santorini is a near paradise on Earth and should be on any traveler’s bucket list."),
            DataItem(R.drawable.interlaken, "Interlaken", "Incredible beauty with the Jungfrau as a background,Enjoy a fairytale world in the lakes and mountains", " Interlaken is located at the foot of one of Switzerland’s famous scenic areas, the Jungfrau. Interlaken is the gateway to the Berner Oberland. Here, not only can you go boating on lakes, you can also take a cable car all the way up to the summit of the Swiss Alps and view the marvelous natural beauty of the Jungfrau. When you add the fact that the weather is pleasant all year round and the environment is so beautiful, you can see why the area has become a famous European holiday destination.\n"),
            DataItem(R.drawable.lijiang, "Lijiang", "Visit this lovely UNESCO World Heritage Site,Find romance after dark on the cobblestone streets", "Listed as a World Heritage Site, Lijiang Old Town was a chaotic and bustling transit and transfer point on both the famous Silk Road and the Tea Horse Road. The ancient city never had city walls. Lying between the river and the mountains, the landscape is magnificent. Inside the old town, the roads are paved with slick cobblestones. The quaint buildings, small arched bridges and beautiful plateau scenery have attracted the interest of countless visitors. The relaxed pace of life and unique Nakhi culture are also part of the Lijiang's charm. The area surrounding the old town also has many beautiful natural landscapes such as the magnificent Yulongxue (Jade Dragon Snow) Mountain and the idyllic Lashihai Lake. If you like ancient towns, Shuhe or Baisha Old Towns are sure to impress with their tranquil breath of life."),
            DataItem(R.drawable.colmar, "Colmar", "A second Venice with romantic French architecture,Roam the town that inspired \"Howl's Moving Castle\"", "Colmar is a city in Grand Est, France. It has many popular attractions, including Little Venice, Eguisheim, Vieux Colmar, making it well worth a visit."),
            DataItem(R.drawable.wuzhen, "Wuzhen", "Experience serenity in the Venice of the East,Enjoy spring in a beautiful ancient water town", "Wuzhen is located in Tongxiang (Zhejiang, China). It has many popular attractions, including Wuzhen Water Town, West Gate, West Gate Night Cruise, making it a popular choice for travelers."),
            DataItem(R.drawable.yangshuo, "Yangshuo", "Guilin's landscape ranks among the world's best,The Lancang River scenery seems cut from a painting", "The county of Yangshuo is part of Guilin, and the best natural features of Guilin’s scenery are concentrated here. The Li and Yulong Rivers are part of this beautiful scenery and make for fine sightseeing, whether you do so on the water by boat or bamboo raft if you choose to ride through. West Street is the main thoroughfare of Yangshuo. Thanks to Yangshuo’s scenic environment, it has attracted countless tourists from abroad. There are many coffee shops and western-style restaurants on West Street, also known as Westerner Street. Yangshuo is also well-known as a spot for outdoor activities, especially rock climbing among karst land formations. The rock climbing business here is already considerably developed, with various challenges that can be undertaken. There are also activities like hiking and cave exploration for visitors to try out."),
            DataItem(R.drawable.lake_tekapo, "Lake Tekapo", "One of only four international dark sky reserves,Gaze upon the emerald lake and dreamy landscapes", "Lake Tekapo is a city in Canterbury, New Zealand. It has many popular attractions, including Church of the Good Shepherd, Lake Tekapo, making it well worth a visit."),
            DataItem(R.drawable.zhouzhuang, "Zhouzhuang", "See great architecture in China's first water town,Like a traditional Chinese painting brought to life", "Zhouzhuang is located in Kunshan (Jiangsu, China). It has many popular attractions, including Zhouzhuang, Shuangqiao, making it a popular choice for travelers."),
            DataItem(R.drawable.ronda, "Ronda", "Hemingway said this is the perfect place to elope,A town with Roman roots and Spain's oldest bullring", "Ronda is a city in Andalusia, Spain. It has many popular attractions, including Puente Nuevo Bridge, Plaza del Toros, Júzcar, making it well worth a visit.\n"),
            DataItem(R.drawable.fenghuang, "Fenghuang", "Visit the most beautiful village in Hunan Province,Let Fenghuang's charm ease your worries and cares", "Fenghuang, located in the southwestern part of western Hunan. It has gradually transformed into a gathering place for young artistic people. The region's long and storied history, legends and folk tales are among the reasons for this as are the ancient-style stilt houses, the clear waters of the Tuojiang River and the heavily ethnic minority atmosphere. Fenghuang’s Phoenix Ancient Town is ideal for walking tours. Nestled deep in the mountains alongside a fast-flowing river, you can visit places such as the Former Residence of Shen Congwen, the Former Residence of Xiong Xiling, the Yang Family Temple, Eastgate Fortress and the Ancient City Museum. The Tuojiang River flows alongside the city walls of Phoenix Ancient Town. While there you can go rafting on the Tuojiang and see and enjoy the hundred-year-old Hmong stilt houses on either bank. This is a unique and pleasurable experience. Outside the ancient city you may spend some time visiting places such as Nanhua Mountain National Forest Park and the Miaowang (King of the Hmong) Cave.")
        )
    }
    fun createIndoList(): MutableList<DataItem>{
        return mutableListOf(
            DataItem(R.drawable.bali, "Bali", "Visit Bali with beatiful island", "One of the most visited and dreamed-of destinations on the modern traveler bucket list, Bali is a kaleidoscope of beautiful beaches, volcanic hills, lush rice paddies, and thousands upon thousands of Indonesian temples. It’s celebrated for its laidback atmosphere that’s attracted backpackers, surfers, and yogis for years, who have come in search of finding their Zen in this tropical paradise.\n" +
                    "\n" +
                    "Nicknamed the ‘Island of the Gods,’ Bali is deeply rooted in the spiritual, with endless Hindu temples boasting colorful architecture all of their own – particularly in Ubud, Bali’s spiritual capital. Yet all of Bali’s wonders have not gone unnoticed, and the island can get uncomfortably packed during the tourist season around August. If possible, school holidays are best avoided too.\n" +
                    "\n" +
                    "Spend your days relaxing on some of Bali’s best beaches and diving in the Coral Triangle with its endless array of magical marine life. But the best part about Bali is just as much about doing a little as a lot. Read your book in a hammock, watch the sun go down, and feel the island’s slow, laidback vibe step up the pace at one of the many animated beachfront bars."),
            DataItem(R.drawable.yogyakarta, "Yogyakarta", "Yogyakarta is a bustling town of some 500,000 people and the most popular tourist destination on Java, due to its proximity to the famous temples of Borobudur and Prambanan.", "Yogyakarta is a bustling town of some 500,000 people and the most popular tourist destination on Java, due to its proximity to the famous temples of Borobudur and Prambanan. The city itself is a center of education and culture, particularly for Javanese fine arts – from theater to ballet performances, and has a wide range of tourist facilities. It is also the last Indonesian city still ruled by a monarchy.\n" +
                    "\n" +
                    "Yogyakarta lies in one of the most seismically active parts of Java and has thus repeatedly been struck by earthquakes and volcano eruptions. In 2006 an earthquake flattened over 300,000 houses while in 2010 the nearby volcano of Mount Merapi erupted, spewing lava over nearby villages.\n" +
                    "\n" +
                    "Apart from nearby Buddhist and Hindu temples, and the sights in the city itself – small enough that it can be explored on foot – Yogyakarta is also a great base for exploring the surrounding villages locked in time by hardened lava on a Merapi Lava Tour, an activity that’s both sobering and captivating."),
            DataItem(R.drawable.komodo_national_park, "Komodo National Park", "Located in Indonesia’s Nusa Tenggara region, Komodo National Park is famous for one thing and one thing only – its reptilian namesake, the Komodo dragon.", "Located in Indonesia’s Nusa Tenggara region, Komodo National Park is famous for one thing and one thing only – its reptilian namesake, the Komodo dragon. Spread across three main islands – Komodo, Rinca, and Padar – as well as a collection of smaller islets, the park provides a sanctuary for this strange looking creature reminiscent of the dinosaurs. It’s the largest living lizard on the planet and can reach a mighty three meters in length! The reptiles roam freely over the islands, and visitors rely on experienced tour guides for sightings and to keep them safe.\n" +
                    "\n" +
                    "Today, the park has expanded to include the conservation of the entire ecosystem both on land and in the ocean. There are several endemic species, such as Rinca rats and fruit bats, as well as wild horses, long-tailed macaques, water buffalo, and several species of dangerous snakes.\n" +
                    "\n" +
                    "But while the terrestrial beings within the Komodo National Park are definitely worth seeing, it’s the marine life that really stands out. The park protects some of the most abundant marine landscapes in the world, part of the Coral Triangle, home to more than 250 species of coral and a plethora of sea sponges and unusual bony fish."),
            DataItem(R.drawable.lombok, "Lombok", "An increasingly popular alternative to overly commercial Bali, Lombok and its offshore coral-ringed Gili Islands are tropical paradises", "An increasingly popular alternative to overly commercial Bali, Lombok and its offshore coral-ringed Gili Islands are tropical paradises. Here, you can enjoy all the appeal of Bali before tourism took over – surfing hotspots, uncrowded beaches, and magical waterfalls tucked within steamy jungles, of which Tiu Kelep Waterfall tops the list without question.\n" +
                    "\n" +
                    "Backpackers head to Lombok in search of adventure. This is likely because its volcano-topped jungle provides for a great trek surrounded by unforgettable scenery. If you’re planning on hiking the Gunung Rinjani volcano and its photogenic crater lake, make sure you’re fit and have booked with a reputable guide – it’s by no means a walk in the park!\n" +
                    "\n" +
                    "There’s also a fantastic nightlife scene when the sun goes down on the satellite islands of Gili, particularly Gili Trawangan. Those in search of culture won’t be disappointed either – the markets in Mataram are a vibrant place to pick up souvenirs while mingling with the locals."),
            DataItem(R.drawable.bromo_tengger_semeru_national_park, "Bromo Tengger Semeru National Park", "Tucked within East Java, Bromo Tengger Semeru National Park is an ethereal yet barren wonderland of volcanic calderas seemingly continuously surrounded by smoke and clouds.", "Tucked within East Java, Bromo Tengger Semeru National Park is an ethereal yet barren wonderland of volcanic calderas seemingly continuously surrounded by smoke and clouds. The park gets its name from the merging of the Hindu Tengger people and the two mountains found in the park – Mount Bromo and Mount Semeru. The latter is the highest mountain in the Java region, and one of the most active volcanoes in Indonesia.\n" +
                    "\n" +
                    "The draw here is less about wildlife and more about the scenery, yet there are still some interesting animals to be seen, such as Java rusa deer, marbled cats, wild pigs, and the occasional leopard. The best part about a visit to this park is the chance to climb a volcano at sunrise for some of the most exceptional views across this otherworldly landscape.\n" +
                    "\n" +
                    "For those who wish to climb this still-active volcano, a permit from the national park authority is required, and you’ll only be allowed to ascend when the mountain isn’t erupting. Mount Bromo is another prominent landmark in the park, characterized by its often-billowing collapsed crater peeking out above the lush lowland valleys."),
            DataItem(R.drawable.bukit_lawang, "Bukit Lawang", "Bukit Lawang is a small village situated at the eastern side of Gunung Leuser National Park about 90 kilometers northwest of Medan, the capital city of North Sumatra. ","Bukit Lawang is a small village situated at the eastern side of Gunung Leuser National Park about 90 kilometers northwest of Medan, the capital city of North Sumatra. A rehabilitation center for orangutans was founded here in 1973. The main purpose is to preserve the decreasing number of orangutan population due to hunting and deforestation.\n" +
                    "\n" +
                    "The ecotourism here provides jobs and an income for local families living in the village and is a worthy charity to support, if not for the animals alone. The chance to see orangutans in the wild is the major drawcard, but the village is also a worthy stop. It’s built in a sustainable way that takes the surrounding environment into consideration.\n" +
                    "\n" +
                    "Bukit Lawang is a popular destination for guided jungle trekking, acting as the gateway to the Gunung Leuser National Park. Here, you can spot Thomas Leaf Monkeys with their unusual haircuts, walk in the footprints of tigers and elephants, and explore on foot with local bird and nature walks." ),
            DataItem(R.drawable.torajaland, "Torajaland", "Nicknamed ‘the Land of the Heavenly Kings,’ Torajaland (Tana Toraja) is tucked within the lush central highlands of Indonesia’s Southern Sulawesi, a region that’s dotted with rice fields, limestone peaks, and bamboo-clad hills.", "Nicknamed ‘the Land of the Heavenly Kings,’ Torajaland (Tana Toraja) is tucked within the lush central highlands of Indonesia’s Southern Sulawesi, a region that’s dotted with rice fields, limestone peaks, and bamboo-clad hills. Home to the Toraja, a Christian and animist people, Tana Toraja has a fascinating culture that’s remained largely and surprisingly independent from western influence.\n" +
                    "\n" +
                    "Torajans are famous for their massive peaked-roof houses known as tongkonan and spectacular but gruesome funeral rites. After a person’s death, the body is kept – often for several years – until the actual funeral ceremony, which can last for several days. The deceased is then finally buried in a small cave or in a hollow tree. The biggest funerals are usually held in the dry-season months of July and August, but there are funerals year-round.\n" +
                    "\n" +
                    "Exploring Tana Toraja with a local guide is expensive but worth it. They’ll give you a sneaky glimpse into these interesting customs and some of the lesser-known burial sites and village compounds known for their colorful exteriors and boat-shaped rooftops. Visit by yourself, and you’ll still be able to see some of the more famous sites on a trekking trip, but you’ll lack the local insight and insider tips that these tours afford."),
            DataItem(R.drawable.flores_island, "Flores Island", "The Indonesian island of Flores means ‘Flowers’ in Portuguese, a name that hails from the European missionaries who arrived in the 16th-century.","The Indonesian island of Flores means ‘Flowers’ in Portuguese, a name that hails from the European missionaries who arrived in the 16th-century. Lying to the east of Sumbawa and to the west of Lembata in Nusa Tenggara, the long island of Flores is famous for its amazing multi-colored crater lakes around Mount Kelimutu, traditional village homestays, and endless opportunities for adventure tourism.\n" +
                    "\n" +
                    "The lakes are truly a sight to behold in every color you can think of – from browns and greens to aqua blue; colors caused by the minerals reacting to the gas of the region’s volcanoes. The Kelimutu three-colored lake is a must-see from the top of the volcano at sunrise.\n" +
                    "\n" +
                    "For those in search of more physical activity, Egon volcano can be reached with a self-guided or guided hike. The north coast has many offshore islands and coral reefs to explore with an exhilarating dive or snorkel. Or you can simply relax and soak your tired muscles in the enchanting hot springs hidden within the jungle – bliss!" ),
            DataItem(R.drawable.tanjung_puting, "Tanjung Puting National Park", "Tanjung Puting National Park is one of the world’s natural wonders celebrated for its endangered orangutans – some of the last of these orange, long-haired primates on Earth.", "Located in the jungles of Borneo – the third-largest island in the world that’s part of Indonesia, Malaysia and the sultanate of Brunei – the park is home to a variety of wild lowland habitats on a peninsula overlooking the Java Sea. Habitats range from swamp forests to alluvial plains and ocean coastline that provides a home to a diverse array of wildlife – so diverse that it was declared a game reserve before being deemed a national park in 1982.\n" +
                    "\n" +
                    "While orangutans are the obvious draw, you’ll also be able to spot the odd-nosed proboscis monkey, the vulnerable clouded leopard, and over 200 species of birds in the park. Couple these rare animal sightings with fresh jungle air and no light pollution making for excellent star gazing, and the park makes for the perfect adventure. Explore on foot or by klotok boat with a knowledgeable guide – it’s up to you."),
            DataItem(R.drawable.raja_ampat_islands, "Raja Ampat Islands", "An island cluster on the northwestern tip of Papua New Guinea, Raja Ampat is one of the most sensational diving destinations in Indonesia.", "An island cluster on the northwestern tip of Papua New Guinea, Raja Ampat is one of the most sensational diving destinations in Indonesia. Raja Ampat – which means ‘Four Kings’ – is made up of four major jungle-clad islands surrounded by turquoise lagoons and pearly-white palm-fringed beaches – Waigeo, Salawati, Misool, and Batanta – along with thousands of smaller islands.\n" +
                    "\n" +
                    "The archipelago is celebrated for its rich marine life and underwater coral reefs – home to as many as 75% of all known coral species! With everything from underwater photography to wreck diving, it’s so beautiful, you should definitely invest in an underwater camera.\n" +
                    "\n" +
                    "But the fun isn’t limited to offshore. The islands are also a fantastic bird-watching destination. Pack your binoculars and keep your eyes peeled for eagles swooping overhead and birds of paradise such as the Wilson’s and Cendrawash chirping in the treetops while you trek to waterfalls and mysterious age-old caves."),
        )}

    override fun onItemClick(data: DataItem) {
        Intent(activity, DetailActivity::class.java).apply {
            putExtra("EXTRA", data)
            startActivity(this)
        }
    }
}