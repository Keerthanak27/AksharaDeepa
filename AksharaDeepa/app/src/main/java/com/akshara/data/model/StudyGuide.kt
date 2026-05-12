package com.akshara.data.model

data class StudyGuide(
    val subject: String,
    val chapter: String,
    val studyGuide: List<StudyGuideSection>
)

data class StudyGuideSection(
    val title: String,
    val icon: String,
    val content: String
)
