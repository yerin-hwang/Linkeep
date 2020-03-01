package ewha.appsolute.linkeep

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NewLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_new_link)

        var clipboard:ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager;

        var paste:Button = findViewById<Button>(R.id.new_btn_paste_link)
        paste.setOnClickListener(View.OnClickListener {
            //클립보드 처리
        })

        var add_hashtag:Button = findViewById<Button>(R.id.new_btn_add_hashtag)
        add_hashtag.setOnClickListener(View.OnClickListener {
            //search 화면
        })

        var gallery:Button = findViewById<Button>(R.id.new_btn_gallery)
        gallery.setOnClickListener(View.OnClickListener {
            //갤러리 호출
        })

        var webpage:Button = findViewById<Button>(R.id.new_btn_web_page)
        webpage.setOnClickListener(View.OnClickListener {
            //웹뷰 호출
        })

        var add:Button = findViewById<Button>(R.id.new_btn_add)
        add.setOnClickListener(View.OnClickListener {
            //모든 항목 입력 validation
        })
    }
}
