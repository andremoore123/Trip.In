package com.andre.tripin.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.tripin.R
import com.andre.tripin.adapter.DataItem
import com.andre.tripin.adapter.RecyclerViewAdapter

class ExploreFragment : Fragment() {
    private val list: MutableList<DataItem> = createList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_explore, container, false)
        val recyclerViewGlobal = view.findViewById<RecyclerView>(R.id.explore_recycler_global)
        recyclerViewGlobal.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecyclerViewAdapter(list, R.layout.places_card)
        }
        recyclerViewGlobal.setHasFixedSize(true)

        val recyclerViewIndo = view.findViewById<RecyclerView>(R.id.explore_recycler_indonesia)
        recyclerViewIndo.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerViewAdapter(list, R.layout.horizontal_card)
        }
        recyclerViewIndo.setHasFixedSize(true)

        return view
    }
    private fun createList(): MutableList<DataItem>{
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
}