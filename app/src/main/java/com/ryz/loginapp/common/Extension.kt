package com.ryz.loginapp.common

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.coder.vincent.smart_snackbar.SNACK_BAR_ICON_POSITION_LEFT
import com.coder.vincent.smart_snackbar.SmartSnackBar
import com.ryz.loginapp.R

fun ImageView.loadRoundedImageUrl(image: String?) {
    Glide.with(this).load(image).transform(CenterCrop(), RoundedCorners(20)).into(this)
}

fun Any.snackBarErrorMessage(appCompatActivity: AppCompatActivity): Unit =
    SmartSnackBar.top(appCompatActivity).config().icon(R.drawable.ic_info).iconSizeDp(24f)
        .iconPosition(
            SNACK_BAR_ICON_POSITION_LEFT
        ).messageColorResource(R.color.white).backgroundColorResource(R.color.md_theme_light_error)
        .apply()
        .show(this.toString())

fun Any.snackBarSuccessMessage(appCompatActivity: AppCompatActivity): Unit =
    SmartSnackBar.top(appCompatActivity).config().icon(R.drawable.ic_info).iconSizeDp(24f)
        .iconPosition(
            SNACK_BAR_ICON_POSITION_LEFT
        ).messageColorResource(R.color.white)
        .backgroundColorResource(R.color.md_theme_light_primary)
        .apply()
        .show(this.toString())