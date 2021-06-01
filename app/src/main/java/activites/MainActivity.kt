
package activites

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dataproject.R
import com.example.dataproject.helpers.CatAdapter
import com.example.dataproject.models.MyCat
import com.example.dataproject.services.CatService
import com.example.dataproject.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadCountries()
    }


    private fun loadCountries() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(CatService::class.java)
        val requestCall =destinationService.getCatFacts()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<MyCat>> {
            override fun onResponse(call: Call<List<MyCat>>, response: Response<List<MyCat>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val countryList  = response.body()!!
                    Log.d("Response", "countrylist size : ${countryList.size}")
                    cat_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = CatAdapter(response.body()!!)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<MyCat>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_LONG).show()
            }
        })
    }
}
