import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey

//package com.example.myfirstproject.utils
//
//import android.app.Activity
//import android.content.Context
//import android.view.View
//import android.view.inputmethod.InputMethodManager
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewpager.widget.ViewPager
//import com.amazonaws.services.s3.model.S3DataSource
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
//import com.example.myfirstproject.database.PaperPrefs
//import com.thetechnocafe.gurleensethi.liteutils.RecyclerAdapterUtil
//import timber.log.Timber
//import java.io.File
//import java.text.SimpleDateFormat
//
//fun Fragment.hideKeyboard(){
//    val imm: InputMethodManager =
//        context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//    imm.hideSoftInputFromWindow(this.view?.windowToken, 0)
//}
//
//fun View.hide(){
//    this.visibility = View.GONE
//}
//
//fun View.show(){
//    this.visibility = View.VISIBLE
//}
//
//fun View.makeInviible(){
//    this.visibility = View.INVISIBLE
//}
//fun String.formatDate(ordinalFormat:String, targetFormat:String):String{
//    val originalFormat = SimpleDateFormat(ordinalFormat)
//    val date = originalFormat.parse(this)
//    val targetFormat = SimpleDateFormat(targetFormat)
//    return  targetFormat.format(date)
//}
//
//
//fun EditText.showKeyboard(context: Context){
//    Utils.showKeyboard(this,context)
//}
////fun <T:Any> RecyclerView.updateRecycler(context: Context, listOfItems:List<T>, layout:Int, listOfLayout:List<Int>, binder: (Map<Int, View>, Int) -> Unit, onClickPosition:(Int) -> Unit, noImageViews:List<View>): RecyclerView.Adapter<*>? {
////    if(listOfItems.isNullOrEmpty()){
////        this.visibility = View.GONE
////        noImageViews.forEach { it.visibility = View.VISIBLE }
////    }else{
////        this.visibility = View.VISIBLE
////        noImageViews.forEach { it.visibility = View.GONE }
////    }
////    this.layoutManager = LinearLayoutManager(context)
////    val reyclerAdaptor = RecyclerAdapterUtil<T>(context,listOfItems,layout)
////    reyclerAdaptor.addViewsList(listOfLayout)
////    reyclerAdaptor.addOnDataBindListener{ _, _, position, innerViews ->
////        binder(innerViews,position)
////    }
////    reyclerAdaptor.addOnClickListener { _, position -> onClickPosition(position) }
////
////    this.adapter = reyclerAdaptor
////
////
////    return adapter
////}
//
////fun <T:Any> RecyclerView.updateRecycler(context: Context, listOfItems:List<T>, layout:Int, listOfLayout:List<Int>, binder: (Map<Int, View>, Int) -> Unit, onClickPosition:(Int) -> Unit): RecyclerView.Adapter<*>? {
////    this.layoutManager = LinearLayoutManager(context)
////    val reyclerAdaptor = RecyclerAdapterUtil<T>(context,listOfItems,layout)
////    reyclerAdaptor.addViewsList(listOfLayout)
////    reyclerAdaptor.addOnDataBindListener{ _, _, position, innerViews ->
////        binder(innerViews,position)
////    }
////    reyclerAdaptor.addOnClickListener { _, position -> onClickPosition(position) }
////
////    this.adapter = reyclerAdaptor
////
////
////    return adapter
////}
//
//fun PaperPrefs.savePref(key: String, value: Any){
//
//    when(value){
//        is String -> {key.saveStringPref(value)}
//        is Boolean -> {key.saveBooleanPref(value)}
//        else -> {
//            key.saveAnyPref(value)
//        }
//    }
//}
//
//
//fun tryAction(action:()->Unit){
//    return try {
//        action()
//    }catch (ex:Exception){
//        Timber.e(ex)
//    }
//}
//
//
//fun <T:Any> tryOperation(action:()-> UseCaseResult<T>): UseCaseResult<T> {
//    return try {
//        action()
//    }catch (ex:Exception){
//        Timber.e(ex)
//        UseCaseResult.Error(ex)
//    }
//}
//fun  tryBackgroundOperation(action:()->Boolean):Boolean{
//    return try {
//        action()
//    }catch (ex:Exception){
//        Timber.e(ex)
//        false
//    }
//}
//
//fun  PaperPrefs.getBooleanPref(key: String):Boolean{
//    return key.getBooleanPref()
//}
//fun  PaperPrefs.getBooleanPref(key: String,defaultValue:Boolean):Boolean{
//    return key.getBooleanPref(defaultValue)
//}
//
//fun <T:Any> PaperPrefs.getAnyPref(key: String):T{
//    return key.getAnyPref()
//}
//fun PaperPrefs.getStringPref(key: String):String{
//    return key.getStringPref()
//}
//
//fun ViewPager.setUpViewPager(viewPagerObjectList:List<ViewPagerObject>, fragmentStateManager: FragmentManager){
//    val pagerAdapter = Utils.MyViewPageStateAdapter(fragmentStateManager)
//    viewPagerObjectList.forEach {
//        pagerAdapter.addFragment(it.fragment,it.title)
//    }
//    this.apply {
//        adapter = pagerAdapter
//    }
//}
//fun ViewPager.setUpViewPager(viewPagerObjectList:List<ViewPagerObject>, transform: ViewPager.PageTransformer, onPageChangeListener: ViewPager.OnPageChangeListener, fragmentStateManager: FragmentManager){
//    val pagerAdapter = Utils.MyViewPageStateAdapter(fragmentStateManager)
//    viewPagerObjectList.forEach {
//        pagerAdapter.addFragment(it.fragment,it.title)
//    }
//    this.apply {
//        adapter = pagerAdapter
//        setPageTransformer(true,transform)
//        addOnPageChangeListener(onPageChangeListener)
//    }
//}
//
//fun TextView.setColor(color:Int, context: Context){
//    this.setTextColor(context.resources.getColor(color))
//}
//fun ImageView.setLocalImage(file: File, applyCircle: Boolean = false) {
//    val glide = Glide.with(this).load(file)
//    if (applyCircle) {
//        glide.apply(RequestOptions.circleCropTransform()).into(this)
//    } else {
//        glide.into(this)
//    }
//}
//data class ViewPagerObject(val fragment: Fragment, val title:String)

fun ImageView.loadImage(fullImageUrl: String, defaultImage: Int, view: Context) {
    val requestOption = RequestOptions()
        .signature(ObjectKey(System.currentTimeMillis().toString()))
        .placeholder(defaultImage).centerCrop()
    Glide.with(view).load(fullImageUrl)
        .dontAnimate()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(requestOption)
        .error(defaultImage)
        .into(this)
    val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
    Glide.with(view).load(fullImageUrl).apply(requestOptions).error(defaultImage).into(this)
}