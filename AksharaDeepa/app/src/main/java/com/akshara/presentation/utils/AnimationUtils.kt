package com.akshara.presentation.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.HapticFeedbackConstants
import android.view.MotionEvent
import android.view.View
import android.view.animation.OvershootInterpolator

/**
 * Extension function to apply the Premium Glassy tap effect.
 * When applied, it causes the View to scale down slightly (0.95) and triggers haptic feedback.
 */
@SuppressLint("ClickableViewAccessibility")
fun View.applyGlossyClickEffect(
    scaleDown: Float = 0.95f,
    durationMs: Long = 150,
    onSafeClick: () -> Unit
) {
    this.setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // Haptic Feedback for micro-interaction
                view.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK)

                // Scale Down & reduce elevation to create "pressed" depth
                ObjectAnimator.ofFloat(view, View.SCALE_X, scaleDown).setDuration(durationMs).start()
                ObjectAnimator.ofFloat(view, View.SCALE_Y, scaleDown).setDuration(durationMs).start()
                ObjectAnimator.ofFloat(view, View.TRANSLATION_Z, -8f).setDuration(durationMs).start()
                
                // If the view has a specific glossy foreground, we can trigger its sweep here
                // (e.g., view.foreground = ContextCompat.getDrawable(...))
                true
            }
            MotionEvent.ACTION_UP -> {
                // Run the Bounce-back animation
                val scaleUpX = ObjectAnimator.ofFloat(view, View.SCALE_X, 1f)
                val scaleUpY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 1f)
                val elevUp = ObjectAnimator.ofFloat(view, View.TRANSLATION_Z, 0f)

                AnimatorSet().apply {
                    playTogether(scaleUpX, scaleUpY, elevUp)
                    duration = durationMs
                    // Subtle overshoot makes it feel organic and premium
                    interpolator = OvershootInterpolator(1.2f) 
                    start()
                }

                // Execute the actual click logic
                onSafeClick()
                
                // Add an elegant click sound if sound effects are enabled
                view.playSoundEffect(android.view.SoundEffectConstants.CLICK)
                true
            }
            MotionEvent.ACTION_CANCEL -> {
                // Restore if the user dragged their finger off the button
                ObjectAnimator.ofFloat(view, View.SCALE_X, 1f).setDuration(durationMs).start()
                ObjectAnimator.ofFloat(view, View.SCALE_Y, 1f).setDuration(durationMs).start()
                ObjectAnimator.ofFloat(view, View.TRANSLATION_Z, 0f).setDuration(durationMs).start()
                true
            }
            else -> false
        }
    }
}
