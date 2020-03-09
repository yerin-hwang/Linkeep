package ewha.appsolute.linkeep

import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_new_link.*

class NewLinkActivity : AppCompatActivity() {

    private val GET_GALLERY_IMAGE = 200
    private val SEARCH_HASHTAGS = 300
//    private val spanCount = 4

//    lateinit var layoutManager:GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_link)

//        layoutManager = GridLayoutManager(this, spanCount)

        var paste: Button = new_btn_paste_link
        paste.setOnClickListener(View.OnClickListener {
            //클립보드 처리
            var clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            if (!(clipboard.hasPrimaryClip())) {
                //데이터가 없거나 텍스트 타입이 아닌 경우
            } else {
                //클립보드에서 젤 앞의 문자열 가져옴
                var item = clipboard.primaryClip?.getItemAt(0)
                var pasteData = ""
                if (item != null) {
                    pasteData = item.text.toString()
                }

                //문자열 교체
                new_text_edit_link.setText(pasteData as CharSequence)
                //알림 메시지
                var myMessage = "붙여넣기 완료"//R.string.new_btn_paste
                Toast.makeText(this, myMessage as CharSequence, Toast.LENGTH_SHORT)
                    .show()
            }
        })


        supportFragmentManager.beginTransaction().run {
            replace(R.id.new_recyclerview, HashtagRecyclerViewFragment())
//                commit()
        }
//        if (savedInstanceState == null) {
//        }


        var addHashtag: Button = findViewById<Button>(R.id.new_btn_add_hashtag)
        addHashtag.setOnClickListener(View.OnClickListener {
            //search 화면
//            val next = Intent(this, SearchActivity::class.java)
//            startActivityForResult(next, SEARCH_HASHTAGS)
//            new_list_hashtag


        })

        var gallery: ConstraintLayout = findViewById<ConstraintLayout>(R.id.new_btn_gallery)
        gallery.setOnClickListener(View.OnClickListener {
            //갤러리 호출
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*"
            )
            startActivityForResult(intent, GET_GALLERY_IMAGE)
        })

        var webpage: ConstraintLayout = findViewById<ConstraintLayout>(R.id.new_btn_web_page)
        webpage.setOnClickListener(View.OnClickListener {
            //웹뷰 호출

        })

        var add: ConstraintLayout = findViewById<ConstraintLayout>(R.id.new_btn_add)
        add.setOnClickListener(View.OnClickListener {
            //모든 항목 입력 validation
            //1. 링크
            //2. 해시태그 1개 이상
            //3. 이미지 (기본 이미지 넣어 놓기)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_GALLERY_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val selectedImageUri: Uri? = data.data
            new_img_thumbnail.setImageURI(selectedImageUri)
        }
    }
}
