package com.example.myrecyclerview.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myrecyclerview.data.database.User
import com.example.myrecyclerview.data.database.UserDao
import com.example.myrecyclerview.data.models.HeroData
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class FavoriteViewModel(val database: UserDao, application: Application) : AndroidViewModel(application){
    val listUsers = MutableLiveData<ArrayList<HeroData>>()
    var userList: List<User>
    var countData: Int

    init {
        userList = database.readAllData()
        countData = database.countAllData()
    }
    companion object{
        private val TAG = FavoriteViewModel::class.java.simpleName
    }

    fun setFavoriteUser() {
        val listItems = ArrayList<HeroData>()
        for (i in 0 until countData) {
            val url = "https://api.github.com/users/${userList[i].user_id}"
            val client = AsyncHttpClient()
            val apiKey = "token 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"
            client.addHeader("Authorization", apiKey)
            client.addHeader("User-Agent", "request")
            client.get(url, object : AsyncHttpResponseHandler() {
                override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
                    try {
                        val result = String(responseBody!!)
                        Log.d(TAG, result)
                        val respondObject = JSONObject(result)
                        val user = HeroData().apply {
                            login = respondObject.getString("login")
                            avatar = respondObject.getString("avatar_url")
                        }
                        listItems.add(user)
                        Log.d("list: ", listUsers.postValue(listItems).toString())
                    } catch(e: Exception) {
                        Log.d("Exception: ", e.message.toString())
                    }
                }

                override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                    when (statusCode) {
                        401 -> "$statusCode : Bad Request"
                        403 -> "$statusCode : Forbidden"
                        404 -> "$statusCode : Not Found"
                        else -> "$statusCode : ${error?.message}"
                    }
                    Log.d("onFailure", error?.message.toString())
                }

            })
        }
        if (listUsers != null){
            listUsers.postValue(listItems)
        }
    }
    fun getUsers() : LiveData<ArrayList<HeroData>> {

        return listUsers
    }
    fun deleteUser(userID: String?){
        database.deleteUser(userID)
    }
}