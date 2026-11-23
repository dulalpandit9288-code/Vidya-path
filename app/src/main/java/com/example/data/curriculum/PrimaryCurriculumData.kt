package com.example.data.curriculum

import com.example.data.model.SubjectType

internal fun primarySeeds(): List<ClassSubjectSeed> = listOf(
    // CLASS 1
    ClassSubjectSeed(
        1, SubjectType.MATH,
        "Numbers 1 to 50 & Counting",
        "Learn to count everyday objects, read number names, and compare smaller and bigger numbers.",
        listOf("Count forward 1 to 50 and backward 20 to 1.", "Place value introduces Tens and Ones (e.g., 24 = 2 Tens + 4 Ones).", "Compare numbers using > (greater), < (smaller), and = (equal)."),
        "24 = 20 + 4  (2 Tens + 4 Ones)",
        "Fun Addition & Shapes",
        "Put groups of objects together with addition (+) and spot circles, squares, and triangles around you.",
        listOf("Addition means putting together; '+' is the plus sign.", "Adding 0 to any number keeps it the same.", "Circle is round with 0 corners; Triangle has 3 sides."),
        "5 + 3 = 8   |   a + 0 = a",
        listOf(
            q("c1m1", "What comes just after 29?", listOf("28", "30", "31", "20"), 1, "Counting forward after 29 gives 30."),
            q("c1m2", "How many sides does a triangle have?", listOf("2", "3", "4", "5"), 1, "A triangle always has 3 sides and 3 corners."),
            q("c1m3", "What is 6 + 4?", listOf("9", "10", "11", "12"), 1, "6 plus 4 equals 10."),
            q("c1m4", "Which number is the biggest?", listOf("14", "41", "29", "35"), 1, "41 has 4 tens, so it is the greatest.")
        )
    ),
    ClassSubjectSeed(
        1, SubjectType.SCIENCE,
        "Living & Non-Living Things",
        "Discover what makes plants, animals, and people living while toys and rocks are non-living.",
        listOf("Living things breathe, eat food, grow, and move on their own.", "Non-living things like a pencil or chair do not grow or need food.", "Green plants are living because they grow from seeds."),
        "Living = Breathe + Grow + Need Food & Water",
        "Our Body & Good Habits",
        "Meet our five sense organs and learn daily cleanliness habits to stay healthy.",
        listOf("Eyes (see), Ears (hear), Nose (smell), Tongue (taste), Skin (feel).", "Brush teeth twice a day and wash hands before meals.", "Drink clean water and eat fresh fruits and vegetables."),
        "5 Sense Organs: Eyes • Ears • Nose • Tongue • Skin",
        listOf(
            q("c1s1", "Which of these is a living thing?", listOf("Wooden chair", "Mango tree", "Plastic ball", "Stone"), 1, "A mango tree grows and needs water and sunlight."),
            q("c1s2", "Which sense organ helps us taste food?", listOf("Nose", "Eyes", "Tongue", "Ears"), 2, "Our tongue detects sweet, salty, sour, and bitter tastes."),
            q("c1s3", "How many sense organs do we have?", listOf("3", "4", "5", "6"), 2, "Humans have 5 primary sense organs."),
            q("c1s4", "What should we do before eating food?", listOf("Wash hands", "Run fast", "Sleep", "Skip water"), 0, "Washing hands with soap removes germs.")
        )
    ),
    ClassSubjectSeed(
        1, SubjectType.HINDI,
        "हिंदी वर्णमाला — स्वर और व्यंजन",
        "अ से अः तक स्वर और क से ज्ञ तक व्यंजन की पहचान व सही उच्चारण सीखें।",
        listOf("हिंदी में 11 मुख्य स्वर होते हैं: अ, आ, इ, ई, उ, ऊ, ऋ, ए, ऐ, ओ, औ।", "क-वर्ग से लेकर प-वर्ग तक व्यंजन आते हैं।", "बिना मात्रा वाले दो और तीन अक्षर के शब्द पढ़ना सीखें (कल, घर, कमल)।"),
        "स्वर (11): अ आ इ ई उ ऊ ऋ ए ऐ ओ औ",
        "मात्रा ज्ञान — आ (ा) व इ (ि)",
        "व्यंजन के साथ मात्रा जोड़कर नए शब्द बनाना सीखें।",
        listOf("'आ' की मात्रा (ा) अक्षर के बाद लगती है: क + ा = का (काम, आम)।", "'इ' की छोटी मात्रा (ि) अक्षर से पहले लगती है: क + ि = कि (किताब)।", "बोलकर पढ़ने से शब्द जल्दी याद होते हैं।"),
        "म + ा + म + ा = मामा  |  द + ि + न = दिन",
        listOf(
            q("c1h1", "इनमें से कौन-सा अक्षर 'स्वर' है?", listOf("क", "म", "अ", "र"), 2, "'अ' एक स्वर है, जबकि क, म, र व्यंजन हैं।"),
            q("c1h2", "'आ' की मात्रा किस शब्द में है?", listOf("नल", "आम", "फल", "घर"), 1, "'आम' में आ स्वर की ध्वनि है; 'कमल' बिना मात्रा का शब्द है।"),
            q("c1h3", "'क + म + ल' से कौन-सा शब्द बनेगा?", listOf("कलम", "कमल", "मलक", "लमक"), 1, "अक्षरों को क्रम से जोड़ने पर 'कमल' बनता है।"),
            q("c1h4", "'दिन' शब्द में किस की मात्रा लगी है?", listOf("ई (ी)", "इ (ि)", "उ (ु)", "ओ (ो)"), 1, "'द' पर छोटी 'इ' की मात्रा (दि) लगी है।")
        )
    ),
    ClassSubjectSeed(
        1, SubjectType.ENGLISH,
        "Alphabet, Vowels & Consonants",
        "Learn all 26 English letters, spot the 5 vowels, and build simple three-letter CVC words.",
        listOf("There are 26 letters in the English alphabet (A to Z).", "The 5 vowels are A, E, I, O, U; the remaining 21 are consonants.", "Use 'an' before vowel sounds (an apple) and 'a' before consonant sounds (a ball)."),
        "Vowels = A, E, I, O, U  |  a + consonant, an + vowel",
        "Naming Words (Nouns)",
        "Everything around us has a name—people, places, animals, and things are naming words.",
        listOf("Person: mother, teacher, Rohan.", "Animal: cow, peacock, dog.", "Place & Thing: school, park, pencil, book."),
        "Noun = Name of Person, Place, Animal, or Thing",
        listOf(
            q("c1e1", "How many vowels are there in English?", listOf("4", "5", "6", "21"), 1, "A, E, I, O, U are the 5 vowels."),
            q("c1e2", "Choose the correct article: ___ umbrella", listOf("a", "an", "two", "are"), 1, "Umbrella begins with a vowel sound 'u', so we use 'an'."),
            q("c1e3", "Which word is a naming word (noun)?", listOf("run", "happy", "school", "blue"), 2, "'School' is the name of a place."),
            q("c1e4", "Which letter is a consonant?", listOf("A", "E", "O", "T"), 3, "T is a consonant; A, E, O are vowels.")
        )
    ),

    // CLASS 2
    ClassSubjectSeed(
        2, SubjectType.MATH,
        "3-Digit Numbers & Place Value",
        "Explore Hundreds, Tens, and Ones up to 999 and practice carry-over addition and subtraction.",
        listOf("10 Tens make 1 Hundred (100).", "Expanded form of 347 = 300 + 40 + 7.", "Even numbers end in 0, 2, 4, 6, 8; odd numbers end in 1, 3, 5, 7, 9."),
        "100 = 10 Tens  |  347 = 3 Hundreds + 4 Tens + 7 Ones",
        "Multiplication as Repeated Addition",
        "Understand tables from 2 to 5 as fast repeated addition.",
        listOf("3 groups of 4 = 4 + 4 + 4 = 3 × 4 = 12.", "Any number multiplied by 0 equals 0.", "Any number multiplied by 1 equals the same number."),
        "a × 0 = 0   |   a × 1 = a   |   4 + 4 + 4 = 3 × 4",
        listOf(
            q("c2m1", "What is the place value of 5 in 528?", listOf("5", "50", "500", "52"), 2, "5 is in the Hundreds place, so its value is 500."),
            q("c2m2", "Which is an even number?", listOf("23", "47", "64", "81"), 2, "64 ends in 4, which is even."),
            q("c2m3", "What is 4 × 5?", listOf("9", "15", "20", "25"), 2, "4 groups of 5 equal 20."),
            q("c2m4", "What is 78 - 25?", listOf("43", "53", "55", "63"), 1, "8 - 5 = 3 and 7 - 2 = 5, so 53.")
        )
    ),
    ClassSubjectSeed(
        2, SubjectType.SCIENCE,
        "Types of Plants & Uses",
        "Learn how trees, shrubs, herbs, climbers, and creepers differ and why plants are our green friends.",
        listOf("Trees (Neem, Mango) are tall with thick woody trunks.", "Herbs (Mint, Tulsi) are small with soft green stems.", "Plants give us oxygen, fruits, grains, cotton, and medicines."),
        "Trees > Shrubs > Herbs  |  Climbers need support",
        "Animals, Habitats & Food",
        "Discover domestic vs. wild animals and what herbivores, carnivores, and omnivores eat.",
        listOf("Herbivores (cow, deer) eat only plants.", "Carnivores (lion, tiger) eat other animals.", "Omnivores (bear, crow) eat both plants and animals."),
        "Plant-eater = Herbivore  |  Meat-eater = Carnivore",
        listOf(
            q("c2s1", "Which plant is a herb?", listOf("Banyan", "Neem", "Mint (Pudina)", "Rose"), 2, "Mint has a soft green stem, making it a herb."),
            q("c2s2", "A cow eats only grass and plants. It is a:", listOf("Carnivore", "Herbivore", "Omnivore", "Creeper"), 1, "Plant-eating animals are herbivores."),
            q("c2s3", "Which part of a plant grows under the soil?", listOf("Leaf", "Flower", "Root", "Fruit"), 2, "Roots grow underground and absorb water."),
            q("c2s4", "Which animal gives us wool?", listOf("Goat", "Sheep", "Horse", "Hen"), 1, "Sheep provide warm wool fibres.")
        )
    ),
    ClassSubjectSeed(
        2, SubjectType.HINDI,
        "संयुक्त व्यंजन व वचन (एकवचन–बहुवचन)",
        "क्ष, त्र, ज्ञ, श्र जैसे संयुक्त अक्षरों और एक से अनेक बनाने के नियम समझें।",
        listOf("एकवचन से एक वस्तु का बोध होता है (लड़का, किताब)।", "बहुवचन से एक से अधिक का बोध होता है (लड़के, किताबें)।", "संयुक्त अक्षर: क्ष (कक्षा), त्र (पत्र), ज्ञ (ज्ञान)।"),
        "लड़का → लड़के  |  तारा → तारे  |  किताब → किताबें",
        "विलोम शब्द (उल्टे अर्थ)",
        "दैनिक जीवन के सरल विलोम शब्दों का अभ्यास करें।",
        listOf("दिन × रात, सुख × दुख, ऊपर × नीचे।", "सच्चा × झूठा, नया × पुराना, अंदर × बाहर।", "विलोम शब्दों से भाषा और वाक्य सुंदर बनते हैं।"),
        "अच्छा × बुरा  |  सुबह × शाम  |  मित्र × शत्रु",
        listOf(
            q("c2h1", "'किताब' का बहुवचन क्या होगा?", listOf("किताबे", "किताबें", "किताबों", "किताबी"), 1, "'किताब' का सही बहुवचन 'किताबें' है।"),
            q("c2h2", "'ऊपर' का विलोम शब्द क्या है?", listOf("आगे", "नीचे", "पास", "दाएँ"), 1, "'ऊपर' का उल्टा अर्थ 'नीचे' होता है।"),
            q("c2h3", "इनमें से संयुक्त अक्षर कौन-सा है?", listOf("प", "र", "क्ष", "ल"), 2, "क्ष (क् + ष) एक संयुक्त व्यंजन है।"),
            q("c2h4", "'रात' का सही विलोम शब्द चुनें:", listOf("शाम", "दिन", "सवेरा", "अँधेरा"), 1, "'रात' का विलोम 'दिन' होता है।")
        )
    ),
    ClassSubjectSeed(
        2, SubjectType.ENGLISH,
        "Singular, Plural & Pronouns",
        "Add -s or -es to make plurals and replace repeated nouns with I, you, he, she, it, we, they.",
        listOf("Add -s for most nouns: book → books, tree → trees.", "Add -es after s, sh, ch, x: bus → buses, box → boxes.", "Pronouns replace nouns: 'Riya is kind. She helps all.'"),
        "One = Singular (box)  |  Many = Plural (boxes)",
        "Action Words (Verbs) & Describing Words",
        "Identify doing words like jump, read, write and describing words (adjectives) like tall, sweet.",
        listOf("Verbs show action: run, sing, cook, study.", "Adjectives describe nouns: a red kite, a sweet mango.", "Every complete sentence starts with a capital letter and ends with a full stop."),
        "Adjective + Noun: sweet mango  |  Verb = Action",
        listOf(
            q("c2e1", "What is the plural of 'box'?", listOf("boxs", "boxes", "boxies", "box"), 1, "Words ending in 'x' take '-es' in the plural."),
            q("c2e2", "Choose the pronoun for 'Arjun': ___ plays cricket.", listOf("She", "It", "He", "They"), 2, "Arjun is a boy, so 'He' is used."),
            q("c2e3", "Find the action word: 'Birds fly in the sky.'", listOf("Birds", "fly", "sky", "the"), 1, "'Fly' shows the action performed by birds."),
            q("c2e4", "Find the describing word: 'That is a tall building.'", listOf("That", "building", "tall", "is"), 2, "'Tall' describes the building.")
        )
    ),

    // CLASS 3
    ClassSubjectSeed(
        3, SubjectType.MATH,
        "Fractions & Sharing Equally",
        "Understand halves (1/2), thirds (1/3), and quarters (1/4) using rotis, chocolates, and shapes.",
        listOf("A fraction represents equal parts of a whole.", "Top number = Numerator; Bottom number = Denominator.", "Two halves (1/2 + 1/2) make 1 whole."),
        "Fraction = Numerator / Denominator   (e.g. 3/4)",
        "Time, Money & Division",
        "Read clocks to 5-minute intervals, calculate rupees & paise, and divide equally.",
        listOf("1 Hour = 60 Minutes; 1 Rupee = 100 Paise.", "Division is equal sharing: 24 ÷ 4 = 6.", "Dividend = Divisor × Quotient + Remainder."),
        "₹1 = 100 paise  |  1 Hour = 60 mins  |  24 ÷ 4 = 6",
        listOf(
            q("c3m1", "How many paise make ₹2?", listOf("100", "150", "200", "500"), 2, "₹1 = 100 paise, so ₹2 = 200 paise."),
            q("c3m2", "If a pizza is cut into 4 equal slices and you eat 1, what fraction did you eat?", listOf("1/2", "1/3", "1/4", "3/4"), 2, "1 out of 4 equal parts is 1/4."),
            q("c3m3", "What is 36 ÷ 6?", listOf("5", "6", "7", "8"), 1, "6 × 6 = 36, so 36 ÷ 6 = 6."),
            q("c3m4", "How many minutes are in 1 hour?", listOf("30", "45", "60", "100"), 2, "1 hour has 60 minutes.")
        )
    ),
    ClassSubjectSeed(
        3, SubjectType.SCIENCE,
        "Water Cycle & Conservation",
        "Trace how water travels from rivers to clouds and back as rain, and why every drop counts.",
        listOf("Evaporation: Sun heats water into invisible water vapour.", "Condensation: Vapour cools high up to form clouds.", "Precipitation: Heavy droplets fall as rain or snow."),
        "Evaporation → Condensation → Precipitation → Collection",
        "Soil, Rocks & Air",
        "Learn what makes up soil, why air occupies space, and how wind helps us.",
        listOf("Air contains nitrogen, oxygen, carbon dioxide, and water vapour.", "Loamy soil is best for growing crops because it holds both air and water.", "Moving air is called wind; a gentle wind is a breeze."),
        "Air = Mixture of Gases  |  Best Crop Soil = Loamy Soil",
        listOf(
            q("c3s1", "Water turning into vapour due to sun's heat is called:", listOf("Condensation", "Evaporation", "Freezing", "Melting"), 1, "Heating turns liquid water into vapour—evaporation."),
            q("c3s2", "Which gas in air do humans need for breathing?", listOf("Nitrogen", "Oxygen", "Helium", "Argon"), 1, "Humans and animals breathe in oxygen."),
            q("c3s3", "Which soil is best for growing plants?", listOf("Sandy", "Clayey", "Loamy", "Rocky"), 2, "Loamy soil has balanced sand, clay, and humus."),
            q("c3s4", "Clouds are formed by which process?", listOf("Condensation", "Filtration", "Boiling", "Digestion"), 0, "Water vapour cools and condenses into tiny droplets.")
        )
    ),
    ClassSubjectSeed(
        3, SubjectType.HINDI,
        "संज्ञा और लिंग भेद",
        "व्यक्ति, वस्तु, स्थान या भाव के नाम को संज्ञा कहते हैं और पुल्लिंग–स्त्रीलिंग की पहचान सीखें।",
        listOf("संज्ञा के तीन मुख्य भेद: व्यक्तिवाचक, जातिवाचक, भाववाचक।", "पुल्लिंग (पुरुष जाति): भाई, शेर, मोर।", "स्त्रीलिंग (स्त्री जाति): बहन, शेरनी, मोरनी।"),
        "लड़का (पुल्लिंग) ↔ लड़की (स्त्रीलिंग)",
        "विशेषण और पर्यायवाची शब्द",
        "संज्ञा की विशेषता बताने वाले शब्द विशेषण और समान अर्थ वाले पर्यायवाची शब्द जानें।",
        listOf("विशेषण: मीठा आम, काला बादल, चार किताबें।", "सूर्य के पर्यायवाची: सूरज, रवि, दिनकर।", "जल के पर्यायवाची: पानी, नीर, वारि।"),
        "पृथ्वी = धरती, धरा, भू  |  कमल = पंकज, नीरज",
        listOf(
            q("c3h1", "'हिमालय' किस प्रकार की संज्ञा है?", listOf("जातिवाचक", "व्यक्तिवाचक", "भाववाचक", "सर्वनाम"), 1, "हिमालय एक विशेष पर्वत का नाम है, अतः व्यक्तिवाचक संज्ञा है।"),
            q("c3h2", "'मोर' का स्त्रीलिंग शब्द क्या है?", listOf("मोरी", "मोरनी", "मोरिन", "मोरा"), 1, "'मोर' का स्त्रीलिंग 'मोरनी' होता है।"),
            q("c3h3", "'जल' का पर्यायवाची शब्द कौन-सा है?", listOf("अनल", "पवन", "नीर", "गगन"), 2, "नीर, पानी और वारि जल के पर्यायवाची हैं।"),
            q("c3h4", "'हरी घास' में विशेषण शब्द कौन-सा है?", listOf("घास", "हरी", "दोनों", "कोई नहीं"), 1, "'हरी' शब्द घास का रंग (विशेषता) बता रहा है।")
        )
    ),
    ClassSubjectSeed(
        3, SubjectType.ENGLISH,
        "Tenses: Present, Past & Future",
        "Use simple present for daily habits, simple past for yesterday, and 'will' for tomorrow.",
        listOf("Simple Present: I walk to school every day.", "Simple Past: I walked to school yesterday (add -ed or use irregular forms like went).", "Simple Future: I will walk to school tomorrow."),
        "Past (-ed / went) ← Present (go) → Future (will go)",
        "Prepositions & Punctuation",
        "Show exact positions using in, on, under, behind, between and master commas & question marks.",
        listOf("'In' inside something; 'On' touching top surface; 'Under' below.", "Use '?' after asking sentences and '!' for strong feelings.", "Capitalize proper nouns like India, Ganga, Monday, Diwali."),
        "in / on / under / between  |  Ask → ?   Exclaim → !",
        listOf(
            q("c3e1", "Choose the past tense of 'go': Yesterday I ___ to Pune.", listOf("go", "goes", "went", "will go"), 2, "'Went' is the simple past form of 'go'."),
            q("c3e2", "Fill in the preposition: The cat is sleeping ___ the table.", listOf("under", "into", "from", "of"), 0, "'Under' indicates position beneath the table."),
            q("c3e3", "Which punctuation ends a question?", listOf(".", ",", "?", "!"), 2, "Questions always end with a question mark (?)."),
            q("c3e4", "Choose the simple future sentence:", listOf("She sang well.", "She sings daily.", "She will sing tomorrow.", "She is singing."), 2, "'Will + verb' expresses the simple future tense.")
        )
    ),

    // CLASS 4
    ClassSubjectSeed(
        4, SubjectType.MATH,
        "Factors, Multiples & Perimeter",
        "Find factors and multiples of numbers and measure the boundary length (perimeter) of shapes.",
        listOf("A factor divides a number exactly (Factors of 12: 1, 2, 3, 4, 6, 12).", "Multiples come from skip-counting tables (Multiples of 4: 4, 8, 12, 16...).", "Perimeter = Sum of all outer sides of a closed shape."),
        "Perimeter of Rectangle = 2 × (Length + Breadth)\nPerimeter of Square = 4 × Side",
        "Area & Metric Measurements",
        "Convert km to m, kg to g, and L to mL, and count unit squares inside a shape for area.",
        listOf("1 km = 1000 m; 1 m = 100 cm; 1 kg = 1000 g; 1 L = 1000 mL.", "Area measures the space covered inside a flat surface.", "Area of Rectangle = Length × Breadth."),
        "1 km = 1000 m  |  1 L = 1000 mL  |  Area = L × B",
        listOf(
            q("c4m1", "What is the perimeter of a square with side 7 cm?", listOf("14 cm", "21 cm", "28 cm", "49 cm"), 2, "Perimeter of square = 4 × side = 4 × 7 = 28 cm."),
            q("c4m2", "How many millilitres are in 3 litres?", listOf("30 mL", "300 mL", "3000 mL", "30000 mL"), 2, "1 L = 1000 mL, so 3 L = 3000 mL."),
            q("c4m3", "Which of these is a factor of 18?", listOf("4", "5", "6", "7"), 2, "18 ÷ 6 = 3 with no remainder."),
            q("c4m4", "What is the area of a rectangle 8 m long and 3 m wide?", listOf("11 sq m", "22 sq m", "24 sq m", "64 sq m"), 2, "Area = Length × Breadth = 8 × 3 = 24 sq m.")
        )
    ),
    ClassSubjectSeed(
        4, SubjectType.SCIENCE,
        "Human Digestive System & Teeth",
        "Follow food from chewing in the mouth to nutrient absorption in the small intestine.",
        listOf("Humans have 4 types of teeth: Incisors (cut), Canines (tear), Premolars & Molars (grind).", "Digestion begins in the mouth with saliva.", "Stomach churns food with digestive juices; small intestine absorbs nutrients."),
        "Mouth → Food Pipe → Stomach → Small Intestine → Large Intestine",
        "Force, Work & Energy",
        "See how push and pull change motion, what friction does, and explore renewable energy.",
        listOf("Force is a push or pull that can move, stop, or change shape of an object.", "Friction slows down moving objects when two surfaces rub.", "Solar energy from the Sun is clean and renewable."),
        "Force = Push or Pull  |  Gravity pulls objects toward Earth",
        listOf(
            q("c4s1", "Which teeth are used for biting and cutting food?", listOf("Molars", "Incisors", "Premolars", "Wisdom"), 1, "Front sharp incisors are used for biting and cutting."),
            q("c4s2", "Where is most digested food absorbed into the blood?", listOf("Mouth", "Food pipe", "Small intestine", "Liver"), 2, "Nutrients pass into blood through the small intestine walls."),
            q("c4s3", "Which force pulls a dropped ball downward?", listOf("Magnetic", "Gravity", "Friction", "Muscular"), 1, "Earth's gravity pulls objects toward its center."),
            q("c4s4", "What slows down a rolling bicycle when you stop pedalling?", listOf("Friction", "Sunlight", "Evaporation", "Magnetism"), 0, "Friction between tyres and road opposes motion.")
        )
    ),
    ClassSubjectSeed(
        4, SubjectType.HINDI,
        "सर्वनाम और क्रिया की पहचान",
        "संज्ञा के स्थान पर प्रयुक्त होने वाले शब्द 'सर्वनाम' और काम करने वाले शब्द 'क्रिया' का अभ्यास करें।",
        listOf("सर्वनाम उदाहरण: मैं, तुम, वह, यह, हम, वे, आप, कौन।", "क्रिया के दो रूप: सकर्मक (कर्म के साथ) और अकर्मक (बिना कर्म)।", "सर्वनाम से वाक्य दोहराव रुकता है और भाषा सहज बनती है।"),
        "राम पढ़ता है → वह पढ़ता है ('वह' = सर्वनाम, 'पढ़ता है' = क्रिया)",
        "मुहावरे व वाक्यांश के लिए एक शब्द",
        "रोचक मुहावरों का अर्थ जानें और बड़े वाक्यांशों के लिए सटीक एक शब्द लिखना सीखें।",
        listOf("आँखों का तारा = बहुत प्यारा।", "नौ दो ग्यारह होना = भाग जाना।", "जो चित्र बनाता हो = चित्रकार; जो पढ़ाता हो = अध्यापक।"),
        "ईद का चाँद होना = बहुत दिनों बाद दिखाई देना",
        listOf(
            q("c4h1", "'वे स्कूल जा रहे हैं।' इस वाक्य में सर्वनाम क्या है?", listOf("स्कूल", "वे", "जा रहे", "हैं"), 1, "'वे' संज्ञा के स्थान पर प्रयुक्त सर्वनाम है।"),
            q("c4h2", "'नौ दो ग्यारह होना' मुहावरे का अर्थ क्या है?", listOf("गिनती करना", "भाग जाना", "सो जाना", "जीतना"), 1, "इस मुहावरे का अर्थ तुरंत भाग जाना है।"),
            q("c4h3", "'जो खेती करता हो' के लिए एक शब्द क्या होगा?", listOf("शिक्षक", "किसान", "सैनिक", "लेखक"), 1, "खेती करने वाले को किसान (कृषक) कहते हैं।"),
            q("c4h4", "'बच्चा जोर से हँसा।' में क्रिया शब्द कौन-सा है?", listOf("बच्चा", "जोर", "से", "हँसा"), 3, "'हँसा' कार्य होने का बोध कराता है, अतः क्रिया है।")
        )
    ),
    ClassSubjectSeed(
        4, SubjectType.ENGLISH,
        "Adverbs & Degrees of Comparison",
        "Describe how actions happen with adverbs (-ly) and compare things with -er / -est.",
        listOf("Adverbs of manner tell how: quickly, softly, carefully.", "Positive → Comparative → Superlative: tall → taller → tallest.", "Use 'more' and 'most' for longer words: beautiful → more beautiful → most beautiful."),
        "tall → taller (than) → the tallest",
        "Conjunctions & Paragraph Writing",
        "Join sentences smoothly using and, but, because, or, so and write structured paragraphs.",
        listOf("'And' joins similar ideas; 'But' joins opposite ideas.", "'Because' gives a reason; 'So' shows a result.", "A good paragraph has a topic sentence, supporting details, and a closing line."),
        "and (add) | but (contrast) | because (reason) | so (result)",
        listOf(
            q("c4e1", "Choose the correct degree: Mount Everest is the ___ peak in the world.", listOf("high", "higher", "highest", "more high"), 2, "Superlative 'highest' compares more than two peaks."),
            q("c4e2", "Identify the adverb: 'Meera solved the puzzle easily.'", listOf("Meera", "solved", "puzzle", "easily"), 3, "'Easily' tells how Meera solved the puzzle."),
            q("c4e3", "Join with the best conjunction: I stayed inside ___ it was raining.", listOf("but", "because", "or", "yet"), 1, "'Because' explains the reason."),
            q("c4e4", "What is the comparative form of 'good'?", listOf("gooder", "more good", "better", "best"), 2, "'Good → better → best' is an irregular comparison.")
        )
    )
)
