@Composable
fun SkillBar(skillName: String, proficiency: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = skillName)
        Box(
            modifier = Modifier
                .weight(1f)
                .height(20.dp)
                .background(Color.LightGray)
        ) {
            Canvas(modifier = Modifier.matchParentSize()) {
                drawRect(color = Color.Blue, size = Size(size.width * proficiency, size.height))
            }
        }
    }
}
