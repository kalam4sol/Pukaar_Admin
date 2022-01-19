package com.example.pukaaradmin

import android.content.Context
import android.content.SharedPreferences
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CommonFunction {
    companion object {
        fun saveToken(context: Context, token: String) {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("token", token)
            editor.apply()
            editor.commit()
        }

        fun getToken(context: Context): String {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val token = sharedPreferences.getString("token", "")
            return "Bearer "+token.toString();
        }

        fun saveName(context: Context, name: String) {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.apply()
            editor.commit()
        }

        fun getName(context: Context): String {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val token = sharedPreferences.getString("name", "")
            return token.toString();
        }
        fun saveUserId(context: Context, id: String) {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("UserId", id)
            editor.apply()
            editor.commit()
        }

        fun getUserId(context: Context): String {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val id = sharedPreferences.getString("UserId", "")
            return id.toString();
        }
        fun dateFormat(dateTime: String): String {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("dd-MM-yyyy hh:mm a")
            return formatter.format(parser.parse(dateTime))
        }
        fun changeDateFormat(date: String?, isTime: Boolean): String? {
            val curFormat = SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss")
            var dateObj: Date? = null
            try {
                dateObj = curFormat.parse(date)
                var postFormater: SimpleDateFormat? = null
                postFormater =
                    if (isTime) SimpleDateFormat("hh:mm a") else SimpleDateFormat("dd-mm-yyyy")
                return postFormater.format(dateObj)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return ""
        }
    }
}