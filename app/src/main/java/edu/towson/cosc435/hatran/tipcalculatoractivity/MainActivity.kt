package edu.towson.cosc435.hatran.tipcalculatoractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_lab.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lab)

        calculate_btn.setOnClickListener{ handleClick()}
    }

    private fun handleClick() {

        try{
            val enteredText= input_amount.editableText.toString()

            val convertType = when (radio_group.checkedRadioButtonId)
            {
                R.id.percent1 -> ConvertType.T10
                R.id.percent2 -> ConvertType.T20
                R.id.percent3 -> ConvertType.T30

                else -> throw Exception()

            }
            val enteredValue = enteredText.toDouble()
            val result = convertTemp(enteredValue, convertType)
            result_tv.text = result.toString()

            val total : Double = enteredValue +result

            result_tv2.text = total.toString()
        }
        catch(e: Exception) {

            result_tv.text = resources.getString(R.string.error_string)
            result_tv2.text = resources.getString(R.string.error_string)

        }
    }
}




