package com.example.data.curriculum

import com.example.data.model.SubjectType

internal fun middleSeeds(): List<ClassSubjectSeed> = listOf(
    // CLASS 5
    ClassSubjectSeed(
        5, SubjectType.MATH,
        "Decimals, Percentages & Angles",
        "Connect fractions to decimals, understand 'per cent' out of 100, and classify angles.",
        listOf("0.5 = 5/10 = 1/2 = 50%.", "Acute angle < 90°, Right angle = 90°, Obtuse angle > 90° and < 180°.", "Straight angle = 180°; Complete angle = 360°."),
        "Percentage = (Part / Whole) × 100%  |  Right Angle = 90°",
        "LCM, HCF & Volume of Cubes",
        "Find Highest Common Factor & Lowest Common Multiple and calculate volume of boxes.",
        listOf("HCF is the largest number dividing both numbers evenly.", "LCM is the smallest common multiple of two numbers.", "Volume of cuboid = Length × Breadth × Height."),
        "Volume = L × B × H  |  HCF × LCM = Product of 2 Numbers",
        listOf(
            q("c5m1", "What is 3/4 written as a percentage?", listOf("25%", "50%", "75%", "80%"), 2, "(3/4) × 100 = 75%."),
            q("c5m2", "An angle measuring 125° is called:", listOf("Acute", "Right", "Obtuse", "Straight"), 2, "Angles between 90° and 180° are obtuse."),
            q("c5m3", "What is the LCM of 4 and 6?", listOf("2", "10", "12", "24"), 2, "Multiples of 4: 4,8,12... and 6: 6,12... Smallest common is 12."),
            q("c5m4", "Volume of a cube with side 3 cm is:", listOf("9 cu cm", "18 cu cm", "27 cu cm", "12 cu cm"), 2, "3 × 3 × 3 = 27 cubic cm.")
        )
    ),
    ClassSubjectSeed(
        5, SubjectType.SCIENCE,
        "Solar System, Earth & Moon",
        "Explore the 8 planets, Earth's rotation vs. revolution, and phases of the Moon.",
        listOf("Earth rotates on its axis every 24 hours causing day and night.", "Earth revolves around the Sun in 365¼ days causing seasons.", "Moon has no light of its own; it reflects sunlight."),
        "8 Planets: Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune",
        "Matter, States & Simple Machines",
        "Compare solids, liquids, and gases and discover levers, pulleys, and inclined planes.",
        listOf("Solids have fixed shape and volume; liquids flow; gases fill containers.", "A lever uses a fulcrum to lift heavy loads easily (seesaw, scissors).", "An inclined plane (ramp) reduces effort to raise objects."),
        "Solid (tight molecules) → Liquid (loose) → Gas (free)",
        listOf(
            q("c5s1", "What causes day and night on Earth?", listOf("Revolution", "Earth's rotation", "Moon's phases", "Eclipses"), 1, "Earth spinning on its axis creates day and night."),
            q("c5s2", "Which is the largest planet in our Solar System?", listOf("Saturn", "Earth", "Jupiter", "Mars"), 2, "Jupiter is the largest gas giant planet."),
            q("c5s3", "A ramp used to push a wheelchair up is an example of:", listOf("Pulley", "Inclined plane", "Wheel & axle", "Wedge"), 1, "A slanted surface is an inclined plane."),
            q("c5s4", "Which state of matter has neither fixed shape nor fixed volume?", listOf("Solid", "Liquid", "Gas", "Crystal"), 2, "Gases expand to fill all available space.")
        )
    ),
    ClassSubjectSeed(
        5, SubjectType.HINDI,
        "काल (भूत, वर्तमान, भविष्यत्) व कारक",
        "वाक्य में समय बताने वाले तीन कालों और संज्ञा-क्रिया को जोड़ने वाले कारक चिह्नों को समझें।",
        listOf("वर्तमान काल: अभी हो रहा काम (मैं पढ़ता हूँ)।", "भूतकाल: बीता हुआ समय (मैं कल बाजार गया था)।", "भविष्यत् काल: आने वाला समय (हम कल खेलेंगे)।"),
        "कर्ता ने | कर्म को | करण से | संप्रदान के लिए | संबंध का-के-की",
        "उपसर्ग और प्रत्यय परिचय",
        "मूल शब्द के आगे (उपसर्ग) या पीछे (प्रत्यय) जुड़कर नए शब्द बनाने की कला सीखें।",
        listOf("उपसर्ग आगे जुड़ता है: अ + सत्य = असत्य, सु + पुत्र = सुपुत्र।", "प्रत्यय पीछे जुड़ता है: सुंदर + ता = सुंदरता, भारत + ईय = भारतीय।", "उपसर्ग-प्रत्यय शब्द के अर्थ में नया बदलाव लाते हैं।"),
        "उपसर्ग + मूल शब्द  |  मूल शब्द + प्रत्यय",
        listOf(
            q("c5h1", "'कल बारिश हुई थी।' यह वाक्य किस काल में है?", listOf("वर्तमान काल", "भूतकाल", "भविष्यत् काल", "अपूर्ण"), 1, "'हुई थी' बीते हुए समय यानी भूतकाल को दर्शाता है।"),
            q("c5h2", "'सुविचार' शब्द में कौन-सा उपसर्ग लगा है?", listOf("चार", "वि", "सु", "आर"), 2, "'सु' उपसर्ग 'विचार' के आगे जुड़ा है।"),
            q("c5h3", "'ईमानदारी' शब्द में कौन-सा प्रत्यय है?", listOf("ईमान", "दार", "ई", "री"), 2, "ईमानदार + ई = ईमानदारी।"),
            q("c5h4", "'ने' किस कारक का चिह्न है?", listOf("कर्म", "कर्ता", "अपादान", "अधिकरण"), 1, "'कर्ता ने' कारक की पहली विभक्ति है।")
        )
    ),
    ClassSubjectSeed(
        5, SubjectType.ENGLISH,
        "Active vs. Passive Voice Basics",
        "Learn how subjects perform actions in Active Voice and receive actions in Passive Voice.",
        listOf("Active: 'Riya wrote a letter.' (Subject does the action).", "Passive: 'A letter was written by Riya.' (Object comes first).", "Keep the tense unchanged when switching from active to passive."),
        "Active: S + V + O  →  Passive: O + be + V3 + by + S",
        "Direct & Indirect Speech Basics",
        "Report what someone said using quotation marks or reporting verbs like said that / asked.",
        listOf("Direct Speech uses exact words in quotes: He said, \"I am happy.\"", "Indirect Speech removes quotes: He said that he was happy.", "Present tense in direct speech usually shifts to past in indirect speech."),
        "Direct: \"I like math.\" → Indirect: She said that she liked math.",
        listOf(
            q("c5e1", "Identify the passive sentence:", listOf("Aman kicked the ball.", "The ball was kicked by Aman.", "Aman is kicking.", "Kick the ball!"), 1, "The object 'the ball' receives the action."),
            q("c5e2", "Change to indirect: He said, \"I am tired.\"", listOf("He said that he is tired.", "He said that he was tired.", "He says he tired.", "He asked he was tired."), 1, "'am' changes to 'was' and 'I' to 'he'."),
            q("c5e3", "What is the past participle (V3) of 'write'?", listOf("wrote", "writing", "written", "writes"), 2, "write – wrote – written."),
            q("c5e4", "Which punctuation encloses exact spoken words?", listOf("Brackets", "Quotation marks", "Hyphen", "Semicolon"), 1, "Quotation marks (\"...\") wrap direct speech.")
        )
    ),

    // CLASS 6
    ClassSubjectSeed(
        6, SubjectType.MATH,
        "Integers, Number Line & Ratio",
        "Work with positive and negative integers on the number line and compare quantities using ratios.",
        listOf("Zero is neither positive nor negative; negative numbers lie left of 0.", "-3 is greater than -8 because it is further right on the number line.", "Ratio compares two quantities in the same unit (a : b)."),
        "(+) + (+) = (+)   |   a : b :: c : d  ⇒  a × d = b × c",
        "Introduction to Algebra",
        "Use letters (variables like x, n) to express general patterns and solve simple equations.",
        listOf("Variables can take different numerical values; constants stay fixed.", "If a matchstick triangle uses 3 sticks, n triangles need 3n sticks.", "Solve x + 5 = 12 by subtracting 5 from both sides → x = 7."),
        "Perimeter of regular pentagon of side s = 5s",
        listOf(
            q("c6m1", "Which integer is greater: -15 or -4?", listOf("-15", "-4", "Both equal", "Cannot compare"), 1, "-4 lies to the right of -15 on the number line."),
            q("c6m2", "Simplify the ratio 18 : 24 to lowest terms:", listOf("2 : 3", "3 : 4", "6 : 8", "9 : 12"), 1, "Dividing both by HCF 6 gives 3 : 4."),
            q("c6m3", "If x - 7 = 10, find x:", listOf("3", "10", "17", "70"), 2, "x = 10 + 7 = 17."),
            q("c6m4", "What is (-6) + (+11)?", listOf("-17", "-5", "5", "17"), 2, "11 - 6 = +5.")
        )
    ),
    ClassSubjectSeed(
        6, SubjectType.SCIENCE,
        "Components of Food & Nutrition",
        "Balance carbohydrates, proteins, fats, vitamins, and minerals and spot deficiency diseases.",
        listOf("Carbohydrates & fats give energy; proteins build & repair muscles.", "Vitamin C deficiency causes Scurvy; Vitamin D deficiency causes Rickets.", "Iodine deficiency leads to Goitre; Iron deficiency causes Anaemia."),
        "Iodine test → Blue-black color confirms Starch",
        "Electricity, Circuits & Magnets",
        "Build closed electric circuits with cells and switches, and test magnetic poles.",
        listOf("Current flows only in a closed circuit from positive to negative terminal.", "Conductors (copper, silver) allow current; insulators (rubber, wood) block it.", "Like poles of a magnet repel; unlike poles attract."),
        "North + South = Attract  |  North + North = Repel",
        listOf(
            q("c6s1", "Which nutrient is primarily responsible for body building and growth?", listOf("Carbohydrates", "Proteins", "Roughage", "Water"), 1, "Proteins repair tissues and build body cells."),
            q("c6s2", "Deficiency of Vitamin C causes:", listOf("Beriberi", "Scurvy", "Rickets", "Goitre"), 1, "Lack of Vitamin C causes bleeding gums (Scurvy)."),
            q("c6s3", "Which material is an electrical insulator?", listOf("Copper wire", "Aluminium foil", "Plastic ruler", "Iron nail"), 2, "Plastic does not conduct electricity."),
            q("c6s4", "A freely suspended bar magnet always aligns in which direction?", listOf("East-West", "North-South", "North-East", "Random"), 1, "Earth's magnetism aligns it North–South.")
        )
    ),
    ClassSubjectSeed(
        6, SubjectType.HINDI,
        "संधि परिचय (स्वर संधि) एवं समास",
        "दो निकटवर्ती वर्णों के मेल से होने वाले विकार (संधि) और शब्दों के संक्षिप्त रूप (समास) को जानें।",
        listOf("दीर्घ संधि: अ/आ + अ/आ = आ (विद्या + आलय = विद्यालय)।", "गुण संधि: अ/आ + इ/ई = ए (सुर + इंद्र = सुरेंद्र)।", "द्वंद्व समास में दोनों पद प्रधान होते हैं (माता-पिता = माता और पिता)।"),
        "विद्या + आलय = विद्यालय  |  सूर्य + उदय = सूर्योदय",
        "पत्र लेखन (औपचारिक व अनौपचारिक)",
        "प्रधानाचार्य को अवकाश पत्र व मित्र को बधाई पत्र लिखने का सही प्रारूप सीखें।",
        listOf("औपचारिक पत्र कार्यालयों/विद्यालय के लिए: सेवा में, श्रीमान प्रधानाचार्य महोदय...", "विषय संक्षिप्त व स्पष्ट होना चाहिए।", "अनौपचारिक पत्र परिवार व मित्रों को आत्मीय भाषा में लिखे जाते हैं।"),
        "दिनांक → संबोधन → मुख्य विषय → भवदीय / तुम्हारा मित्र",
        listOf(
            q("c6h1", "'हिम + आलय' की सही संधि क्या होगी?", listOf("हिमलया", "हिमालय", "हेमालय", "हिमआलय"), 1, "अ + आ = आ (दीर्घ स्वर संधि) से 'हिमालय' बनता है।"),
            q("c6h2", "'दिन-रात' में कौन-सा समास है?", listOf("द्विगु", "द्वंद्व", "तत्पुरुष", "अव्ययीभाव"), 1, "यहाँ 'दिन और रात' दोनों पद प्रधान हैं, अतः द्वंद्व समास है।"),
            q("c6h3", "विद्यालय में अवकाश हेतु लिखा गया पत्र कहलाता है:", listOf("अनौपचारिक", "औपचारिक", "निमंत्रण", "डायरी"), 1, "कार्यालय या प्रधानाचार्य को लिखा पत्र औपचारिक होता है।"),
            q("c6h4", "'महा + ईश' से कौन-सा शब्द बनेगा?", listOf("महाश", "महेश", "महीश", "महईश"), 1, "आ + ई = ए (गुण संधि) से 'महेश' बनता है।")
        )
    ),
    ClassSubjectSeed(
        6, SubjectType.ENGLISH,
        "Types of Sentences & Clauses",
        "Distinguish declarative, interrogative, imperative, and exclamatory sentences.",
        listOf("Declarative states a fact; Interrogative asks a question.", "Imperative gives a command or request ('Please open the book').", "Exclamatory expresses surprise or joy ('What a brilliant catch!')."),
        "Subject + Predicate = Complete Sentence",
        "Reading Comprehension & Modals",
        "Use modal verbs (can, could, may, must, should) accurately and infer main ideas from passages.",
        listOf("'Can' shows ability; 'May' asks polite permission; 'Must' shows strong duty.", "Skim first for the central theme, then scan for exact facts.", "Always answer comprehension questions in your own clear words."),
        "can (ability) | may (permission) | must (necessity)",
        listOf(
            q("c6e1", "Identify the sentence type: 'Please close the window.'", listOf("Declarative", "Imperative", "Interrogative", "Exclamatory"), 1, "Requests and commands are imperative sentences."),
            q("c6e2", "Fill in the modal: You ___ obey traffic rules for safety.", listOf("might", "must", "could", "would"), 1, "'Must' expresses essential duty/obligation."),
            q("c6e3", "In 'The brave soldier saved the village', what is the subject?", listOf("saved the village", "The brave soldier", "village", "brave"), 1, "The noun phrase performing the action is the subject."),
            q("c6e4", "Which modal asks polite permission?", listOf("Must", "May", "Should", "Will"), 1, "'May I come in?' is polite permission.")
        )
    ),

    // CLASS 7
    ClassSubjectSeed(
        7, SubjectType.MATH,
        "Simple Equations & Lines–Angles",
        "Solve linear equations by balancing sides and identify complementary, supplementary, and parallel-line angles.",
        listOf("Complementary angles sum to 90°; Supplementary angles sum to 180°.", "Vertically opposite angles formed by intersecting lines are always equal.", "When a transversal cuts parallel lines, alternate interior angles are equal."),
        "Complementary: a + b = 90°  |  Supplementary: a + b = 180°",
        "Triangles, Exponents & Powers",
        "Apply the Angle Sum Property of triangles and laws of exponents.",
        listOf("Sum of interior angles of any triangle = 180°.", "Exterior angle = Sum of two opposite interior angles.", "a^m × a^n = a^(m+n)  and  a^0 = 1 (for a ≠ 0)."),
        "∠A + ∠B + ∠C = 180°  |  a^m ÷ a^n = a^(m-n)",
        listOf(
            q("c7m1", "Find the supplement of 65°:", listOf("25°", "105°", "115°", "125°"), 2, "180° - 65° = 115°."),
            q("c7m2", "Two angles of a triangle are 50° and 60°. Find the third angle:", listOf("60°", "70°", "80°", "90°"), 1, "180° - (50° + 60°) = 70°."),
            q("c7m3", "What is the value of 2^3 × 2^2?", listOf("2^5 = 32", "2^6 = 64", "4^5", "16"), 0, "Using a^m × a^n = a^(m+n), 2^(3+2) = 2^5 = 32."),
            q("c7m4", "Solve: 3x + 4 = 19", listOf("x = 3", "x = 5", "x = 6", "x = 7"), 1, "3x = 15, so x = 5.")
        )
    ),
    ClassSubjectSeed(
        7, SubjectType.SCIENCE,
        "Acids, Bases & Neutralisation",
        "Test substances with litmus, turmeric, and China rose indicators and understand neutralisation.",
        listOf("Acids taste sour and turn blue litmus red (lemon juice, vinegar).", "Bases taste bitter, feel soapy, and turn red litmus blue (baking soda, soap).", "Acid + Base → Salt + Water + Heat (Neutralisation)."),
        "Acid + Base → Salt + Water  (e.g., HCl + NaOH → NaCl + H₂O)",
        "Heat Transfer & Light",
        "Compare conduction, convection, radiation and study reflection in mirrors and lenses.",
        listOf("Conduction occurs in solids; Convection in liquids & gases; Radiation needs no medium.", "Concave mirrors converge light (used by dentists & torches); Convex mirrors give wide rear views.", "White sunlight splits into 7 rainbow colours (VIBGYOR)."),
        "Plane Mirror: Virtual, Erect, Same-size, Laterally Inverted",
        listOf(
            q("c7s1", "An acid turns blue litmus paper:", listOf("Green", "Red", "Yellow", "Colorless"), 1, "Acids turn blue litmus red."),
            q("c7s2", "Heat from the Sun reaches Earth through space by:", listOf("Conduction", "Convection", "Radiation", "Evaporation"), 2, "Radiation does not require any medium."),
            q("c7s3", "Which mirror is used as a rear-view mirror in vehicles?", listOf("Plane", "Concave", "Convex", "Cylindrical"), 2, "Convex mirrors always form erect images with a wider field of view."),
            q("c7s4", "Ant bite injects formic acid. Rubbing moist baking soda helps because it:", listOf("Neutralises acid", "Freezes skin", "Adds more acid", "Evaporates"), 0, "Baking soda is a mild base that neutralises formic acid.")
        )
    ),
    ClassSubjectSeed(
        7, SubjectType.HINDI,
        "अलंकार परिचय (अनुप्रास व उपमा)",
        "काव्य की सुंदरता बढ़ाने वाले शब्दालंकार और अर्थालंकार के मुख्य भेद उदाहरण सहित सीखें।",
        listOf("अनुप्रास अलंकार: एक ही वर्ण की बार-बार आवृत्ति (चारु चंद्र की चंचल किरणें)।", "उपमा अलंकार: समान गुण के कारण किसी से तुलना (सा, सी, सम शब्द आते हैं)।", "रूपक अलंकार: उपमेय पर उपमान का सीधा आरोप (चरण-कमल बंदौ हरिराई)।"),
        "अनुप्रास = वर्ण आवृत्ति  |  उपमा = तुलना (पीपर पात सरिस मन डोला)",
        "संवाद एवं अनुच्छेद लेखन",
        "दो पात्रों के बीच स्वाभाविक बातचीत (संवाद) और किसी विषय पर सटीक अनुच्छेद लिखना सीखें।",
        listOf("संवाद सरल, रोचक और विषय के अनुकूल होना चाहिए।", "अनुच्छेद में मुख्य बिंदु क्रमबद्ध व 80–100 शब्दों में लिखें।", "विराम चिह्नों (। , ? !) का सही प्रयोग अर्थ स्पष्ट करता है।"),
        "संवाद = पात्र का नाम : कथन  |  क्रमबद्ध विचार = श्रेष्ठ अनुच्छेद",
        listOf(
            q("c7h1", "'तरनि तनूजा तट तमाल तरुवर बहु छाए' में कौन-सा अलंकार है?", listOf("उपमा", "अनुप्रास", "यमक", "रूपक"), 1, "'त' वर्ण की बार-बार आवृत्ति होने से अनुप्रास अलंकार है।"),
            q("c7h2", "जहाँ गुणों की समानता के कारण तुलना की जाए, वहाँ होता है:", listOf("अनुप्रास", "श्लेष", "उपमा", "अतिशयोक्ति"), 2, "तुलना दर्शाने वाले अलंकार को उपमा कहते हैं।"),
            q("c7h3", "दो लोगों की आपसी बातचीत को लिखना कहलाता है:", listOf("निबंध", "संवाद लेखन", "सारांश", "सूचना"), 1, "पात्रों की बातचीत को संवाद लेखन कहते हैं।"),
            q("c7h4", "इनमें से विस्मयादिबोधक चिह्न कौन-सा है?", listOf("।", "?", "!", ","), 2, "आश्चर्य या हर्ष प्रकट करने के लिए '!' का उपयोग होता है।")
        )
    ),
    ClassSubjectSeed(
        7, SubjectType.ENGLISH,
        "Finite vs. Non-Finite Verbs & Gerunds",
        "Spot verbs that change with tense/subject versus infinitives (to + verb), gerunds (-ing nouns), and participles.",
        listOf("Finite verbs change with subject & tense: 'She plays / They played.'", "Infinitive: 'to + base verb' (I like to read).", "Gerund: verb + -ing acting as a noun ('Swimming is good exercise')."),
        "Infinitive = to + V1   |   Gerund = V1 + ing (as Noun)",
        "Formal Letter & Notice Writing",
        "Write crisp school notices and formal application letters with accurate layout.",
        listOf("Notice box includes: Institution Name, NOTICE, Date, Heading, Body, Signature.", "Include What, When, Where, and Whom to contact inside 50 words.", "Keep formal tone polite and concise."),
        "Notice = [Box] Name → NOTICE → Date → Title → Details → Sign",
        listOf(
            q("c7e1", "Identify the gerund: 'Painting relaxes my mind.'", listOf("relaxes", "mind", "Painting", "my"), 2, "'Painting' acts as the noun subject of the sentence."),
            q("c7e2", "Identify the infinitive: 'He wants to learn Sanskrit.'", listOf("wants", "to learn", "Sanskrit", "He"), 1, "'to + learn' is the infinitive."),
            q("c7e3", "A school notice should always be enclosed inside a:", listOf("Circle", "Box", "Triangle", "Margin"), 1, "Standard notice format places all content inside a neat box."),
            q("c7e4", "Which verb is finite in 'They tried to help'?", listOf("tried", "to help", "They", "None"), 0, "'Tried' shows past tense and agrees with the subject.")
        )
    ),

    // CLASS 8
    ClassSubjectSeed(
        8, SubjectType.MATH,
        "Algebraic Identities & Factorisation",
        "Master key square identities and factorise algebraic expressions cleanly.",
        listOf("(a + b)² = a² + 2ab + b²", "(a - b)² = a² - 2ab + b²", "a² - b² = (a + b)(a - b)"),
        "(x + a)(x + b) = x² + (a + b)x + ab",
        "Mensuration: Cylinders & Quadrilaterals",
        "Compute surface areas and volumes of cubes, cuboids, and right circular cylinders.",
        listOf("Area of Trapezium = ½ × (sum of parallel sides) × height.", "Curved Surface Area of Cylinder = 2πrh; Total Surface Area = 2πr(r + h).", "Volume of Cylinder = πr²h."),
        "Cylinder Volume = πr²h   |   CSA = 2πrh",
        listOf(
            q("c8m1", "Expand (x + 5)²:", listOf("x² + 25", "x² + 5x + 25", "x² + 10x + 25", "x² - 10x + 25"), 2, "Using (a+b)² = a² + 2ab + b², we get x² + 10x + 25."),
            q("c8m2", "Factorise x² - 49:", listOf("(x - 7)²", "(x + 7)(x - 7)", "(x + 49)(x - 1)", "(x + 7)²"), 1, "a² - b² = (a+b)(a-b) gives (x+7)(x-7)."),
            q("c8m3", "Formula for volume of a cylinder is:", listOf("2πrh", "πr²h", "2πr(r+h)", "4/3 πr³"), 1, "Base area πr² multiplied by height h gives πr²h."),
            q("c8m4", "If a² + 2ab + b² = 100 and a, b > 0, what is a + b?", listOf("10", "20", "50", "100"), 0, "(a+b)² = 100 ⇒ a + b = 10.")
        )
    ),
    ClassSubjectSeed(
        8, SubjectType.SCIENCE,
        "Cell Structure & Microorganisms",
        "Compare plant vs. animal cells and learn how helpful and harmful microbes shape our world.",
        listOf("Cell is the basic structural & functional unit of life (discovered by Robert Hooke).", "Plant cells have a rigid Cell Wall and Chloroplasts; animal cells do not.", "Rhizobium fixes nitrogen in legume roots; Lactobacillus turns milk into curd."),
        "Nucleus = Control Center  |  Mitochondria = Powerhouse",
        "Force, Pressure & Sound",
        "Calculate pressure (Force / Area) and understand frequency, pitch, and loudness of sound.",
        listOf("Pressure = Force / Area (SI unit: Pascal). Smaller area creates higher pressure.", "Sound travels fastest in solids, slower in liquids, and slowest in gases (cannot travel in vacuum).", "Frequency is measured in Hertz (Hz); higher frequency = higher pitch."),
        "Pressure = Force / Area   |   Frequency (Hz) = Vibrations / sec",
        listOf(
            q("c8s1", "Which organelle is present in plant cells but absent in animal cells?", listOf("Nucleus", "Cytoplasm", "Cell wall", "Cell membrane"), 2, "Only plant cells (and fungi/bacteria) have a cell wall."),
            q("c8s2", "Which bacterium helps convert milk into curd?", listOf("Rhizobium", "Lactobacillus", "Amoeba", "Penicillium"), 1, "Lactobacillus multiplies in warm milk to form curd."),
            q("c8s3", "Sound cannot travel through:", listOf("Steel", "Water", "Air", "Vacuum"), 3, "Sound needs a material medium to propagate."),
            q("c8s4", "Why do school bags have wide straps?", listOf("Look stylish", "Increase area to reduce pressure", "Increase weight", "Reduce friction"), 1, "Larger contact area reduces pressure on the shoulders.")
        )
    ),
    ClassSubjectSeed(
        8, SubjectType.HINDI,
        "पद परिचय व वाक्य के भेद",
        "रचना के आधार पर सरल, संयुक्त व मिश्र वाक्य तथा पदों का व्याकरणिक परिचय सीखें।",
        listOf("सरल वाक्य में एक उद्देश्य और एक ही मुख्य क्रिया होती है।", "संयुक्त वाक्य 'और, किंतु, परंतु, या' जैसे योजकों से जुड़ता है।", "मिश्र वाक्य में एक प्रधान उपवाक्य और एक आश्रित उपवाक्य होता है (जब..., तब...)।"),
        "सरल (1 क्रिया)  |  संयुक्त (और/किंतु)  |  मिश्र (क्योंकि/जो-सो)",
        "तत्सम-तद्भव व मुहावरे-लोकोक्तियाँ",
        "संस्कृत से आए तत्सम शब्दों और उनके बदले हुए तद्भव रूपों की पहचान करें।",
        listOf("तत्सम → तद्भव: दुग्ध → दूध, अग्नि → आग, सूर्य → सूरज, हस्त → हाथ।", "लोकोक्ति लोक-अनुभव पर आधारित पूरा वाक्य होती है (अधजल गगरी छलकत जाए)।", "मुहावरा वाक्यांश होता है जो विशेष लक्ष्यार्थ देता है।"),
        "तत्सम (संस्कृत समान) → तद्भव (परिवर्तित हिंदी रूप)",
        listOf(
            q("c8h1", "'मेहनत करो अन्यथा असफल हो जाओगे।' यह किस प्रकार का वाक्य है?", listOf("सरल", "संयुक्त", "मिश्र", "संदेहवाचक"), 1, "'अन्यथा' योजक दो स्वतंत्र उपवाक्यों को जोड़ता है, अतः संयुक्त वाक्य है।"),
            q("c8h2", "'दुग्ध' शब्द का तद्भव रूप क्या है?", listOf("दही", "दूध", "घी", "मक्खन"), 1, "संस्कृत 'दुग्ध' का तद्भव रूप 'दूध' है।"),
            q("c8h3", "'अग्नि' कैसा शब्द है?", listOf("तद्भव", "तत्सम", "देशज", "विदेशी"), 1, "'अग्नि' बिना परिवर्तन संस्कृत से आया तत्सम शब्द है।"),
            q("c8h4", "'अधजल गगरी छलकत जाए' लोकोक्ति का अर्थ है:", listOf("पानी भरना", "अल्प ज्ञान का दिखावा करना", "गगरी टूटना", "मेहनत करना"), 1, "कम ज्ञान होने पर अधिक दिखावा करना इसका अर्थ है।")
        )
    ),
    ClassSubjectSeed(
        8, SubjectType.ENGLISH,
        "Clauses: Noun, Adjective & Adverb",
        "Build complex sentences cleanly by recognizing dependent clauses and relative pronouns.",
        listOf("Adjective (Relative) Clause begins with who, which, that and describes a noun.", "Adverb Clause begins with when, while, although, if, because.", "Noun Clause acts as a subject or object ('What you said is true')."),
        "Main Clause + Subordinator + Dependent Clause",
        "Determiners & Editing Errors",
        "Choose between few / a few, little / a little, each / every, much / many in Board-style editing tasks.",
        listOf("Countable nouns take many / few / a few; Uncountable take much / little / a little.", "'A few' means some (positive); 'Few' means hardly any (negative).", "'Each' focuses on individuals; 'Every' looks at the whole group."),
        "Countable: few / many  |  Uncountable: little / much",
        listOf(
            q("c8e1", "Choose the correct determiner: There is ___ milk left, enough for one cup of tea.", listOf("little", "a little", "few", "a few"), 1, "Milk is uncountable, and 'a little' means a small positive amount."),
            q("c8e2", "Identify the clause type: 'The boy who won the medal is my cousin.'", listOf("Noun clause", "Adjective clause", "Adverb clause", "Principal clause"), 1, "'Who won the medal' modifies the noun 'boy'."),
            q("c8e3", "Choose the right word: How ___ books are in your bag?", listOf("much", "many", "little", "less"), 1, "Books are countable, so use 'many'."),
            q("c8e4", "Which sentence uses 'few' correctly?", listOf("Few water is left.", "A few students were absent today.", "He has few money.", "She drank few tea."), 1, "'Students' is countable plural, so 'a few' fits.")
        )
    )
)
