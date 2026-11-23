package com.example.data.curriculum

import com.example.data.model.SubjectType

internal fun secondarySeeds(): List<ClassSubjectSeed> = listOf(
    // CLASS 9
    ClassSubjectSeed(
        9, SubjectType.MATH,
        "Number Systems & Polynomials",
        "Classify rational & irrational numbers, simplify surds, and apply Remainder & Factor Theorems.",
        listOf("Rational numbers have terminating or repeating decimals (p/q, q ≠ 0).", "Irrational numbers like √2, π are non-terminating and non-repeating.", "Factor Theorem: (x - a) is a factor of p(x) if and only if p(a) = 0."),
        "(x + y + z)² = x² + y² + z² + 2(xy + yz + zx)\nx³ + y³ = (x + y)(x² - xy + y²)",
        "Triangles & Heron's Formula",
        "Prove triangle congruence (SAS, ASA, SSS, RHS) and compute area using Heron's Formula.",
        listOf("Congruence criteria: SAS, ASA, AAS, SSS, and RHS (right triangles).", "Semi-perimeter s = (a + b + c) / 2.", "Area of triangle = √[s(s - a)(s - b)(s - c)]."),
        "s = (a + b + c)/2   |   Area = √[s(s - a)(s - b)(s - c)]",
        listOf(
            q("c9m1", "Which of these is an irrational number?", listOf("0.25", "3/7", "√5", "√16"), 2, "√5 cannot be written as p/q and is non-terminating, non-repeating."),
            q("c9m2", "If p(x) = x² - 5x + 6, find p(2):", listOf("0", "2", "4", "-2"), 0, "2² - 5(2) + 6 = 4 - 10 + 6 = 0, so (x-2) is a factor."),
            q("c9m3", "What is the semi-perimeter of a triangle with sides 5, 12, 13?", listOf("15", "20", "30", "10"), 0, "s = (5 + 12 + 13) / 2 = 30 / 2 = 15."),
            q("c9m4", "Which is NOT a valid triangle congruence rule?", listOf("SAS", "SSS", "AAA", "ASA"), 2, "AAA proves similarity, not congruence.")
        )
    ),
    ClassSubjectSeed(
        9, SubjectType.SCIENCE,
        "Laws of Motion & Gravitation",
        "Master Newton's three laws, momentum (p = mv), and the Universal Law of Gravitation.",
        listOf("1st Law (Inertia): An object stays at rest or uniform motion unless acted on by net force.", "2nd Law: F = ma (rate of change of momentum is proportional to applied force).", "3rd Law: Every action has an equal and opposite reaction."),
        "F = m × a   |   F = G(M₁M₂) / r²   |   g = 9.8 m/s²",
        "Atoms, Molecules & Mole Concept",
        "Apply Laws of Chemical Combination, write chemical formulas, and count particles with the Mole.",
        listOf("1 Mole = 6.022 × 10²³ particles (Avogadro's Number).", "Mass = Number of moles × Molar mass.", "Law of Conservation of Mass: Mass is neither created nor destroyed in a reaction."),
        "n = Given Mass / Molar Mass   |   Nₐ = 6.022 × 10²³",
        listOf(
            q("c9s1", "What is the SI unit of force?", listOf("Joule", "Newton", "Pascal", "Watt"), 1, "Force is measured in Newton (kg·m/s²)."),
            q("c9s2", "A 5 kg object accelerates at 4 m/s². Net force acting on it is:", listOf("9 N", "1.25 N", "20 N", "40 N"), 2, "F = m × a = 5 × 4 = 20 N."),
            q("c9s3", "How many particles are in 1 mole of any substance?", listOf("6.022 × 10²³", "3.14 × 10²²", "9.8 × 10²³", "1.6 × 10⁻¹⁹"), 0, "Avogadro constant Nₐ = 6.022 × 10²³."),
            q("c9s4", "Rocket propulsion works directly on:", listOf("Newton's 1st Law", "Newton's 3rd Law", "Archimedes Principle", "Ohm's Law"), 1, "Exhaust gases pushed downward propel the rocket upward (action-reaction).")
        )
    ),
    ClassSubjectSeed(
        9, SubjectType.HINDI,
        "अर्थ के आधार पर वाक्य के आठ भेद",
        "विधानवाचक से लेकर संकेतवाचक व विस्मयवाचक तक अर्थ के आधार पर वाक्य के आठों भेद समझें।",
        listOf("1. विधानवाचक (सामान्य कथन), 2. निषेधवाचक (नहीं), 3. प्रश्नवाचक (?), 4. आज्ञावाचक।", "5. इच्छावाचक (शुभकामना), 6. संदेहवाचक (शायद), 7. विस्मयवाचक (!), 8. संकेतवाचक (शर्त)।", "'यदि परिश्रम करोगे तो सफल होगे' — संकेतवाचक वाक्य का उदाहरण है।"),
        "निषेध = न/मत | संदेह = शायद/हो सकता है | संकेत = यदि...तो",
        "दोहे, पद एवं संवाद-संदेश लेखन",
        "कबीर की साखियों व रहीम के दोहों का केंद्रीय भाव तथा आधुनिक संदेश लेखन का प्रारूप सीखें।",
        listOf("कबीरदास ने बाह्य आडंबर की जगह प्रेम, सत्य और सद्भाव को श्रेष्ठ बताया।", "संदेश लेखन बॉक्स में दिनांक, समय, संबोधन, मुख्य संदेश (30–40 शब्द) व नाम के साथ लिखा जाता है।", "भाषा स्पष्ट, प्रभावशाली और व्याकरण-सम्मत रखें।"),
        "संदेश = [बॉक्स] संदेश → दिनांक/समय → संबोधन → 40 शब्द → प्रेषक",
        listOf(
            q("c9h1", "'शायद आज शाम वर्षा हो।' यह किस प्रकार का वाक्य है?", listOf("इच्छावाचक", "संदेहवाचक", "संकेतवाचक", "आज्ञावाचक"), 1, "'शायद' शब्द अनिश्चय या संदेह को दर्शाता है।"),
            q("c9h2", "'तुम्हारी यात्रा मंगलमय हो।' में वाक्य भेद है:", listOf("इच्छावाचक", "निषेधवाचक", "प्रश्नवाचक", "विधानवाचक"), 0, "शुभकामना या आशीर्वाद इच्छावाचक वाक्य में आते हैं।"),
            q("c9h3", "कबीर की साखियों का मुख्य संदेश क्या है?", listOf("युद्ध", "सत्य, प्रेम व आडंबर का त्याग", "धन संचय", "आलस्य"), 1, "कबीर ने सदाचार, सत्य और मानव प्रेम का उपदेश दिया।"),
            q("c9h4", "'यदि तुम समय पर आते तो बस न छूटती।' किस भेद का उदाहरण है?", listOf("संकेतवाचक", "संदेहवाचक", "आज्ञावाचक", "विस्मयवाचक"), 0, "एक क्रिया का दूसरी पर निर्भर होना संकेतवाचक वाक्य है।")
        )
    ),
    ClassSubjectSeed(
        9, SubjectType.ENGLISH,
        "Subject–Verb Concord & Reported Speech",
        "Ensure subjects agree with verbs in tricky structures and convert commands & questions into reported speech.",
        listOf("'Neither the teacher nor the students were late.' (Verb matches closer subject).", "Collective nouns take singular verbs when acting as one unit ('The team is winning').", "Reported questions drop 'do/does/did' and use statement word order (subject before verb)."),
        "Either A or B → Verb agrees with B  |  Each/Everyone → Singular Verb",
        "Diary Entry & Descriptive Paragraph",
        "Express personal reflections in first person with date/day/time and vivid sensory imagery.",
        listOf("Diary format: Day & Date, Time, Dear Diary, First-person reflection, Name.", "Use past tense for events already experienced and present/future for feelings & hopes.", "Use rich sensory adjectives in descriptive paragraphs."),
        "Diary = Date & Day → Time → Salutation → Reflection → Name",
        listOf(
            q("c9e1", "Choose the correct verb: Neither Rohan nor his friends ___ ready.", listOf("is", "was", "are", "has"), 2, "With 'neither...nor', the verb agrees with the nearer plural noun 'friends'."),
            q("c9e2", "Choose the correct verb: Everyone in the class ___ excited.", listOf("are", "were", "is", "have"), 2, "'Everyone' is an indefinite singular pronoun."),
            q("c9e3", "Convert to reported speech: She asked me, \"Where do you live?\"", listOf("She asked me where did I live.", "She asked me where I lived.", "She asked me where do I live.", "She asked where I am living."), 1, "Reported questions use statement order without 'do/did'."),
            q("c9e4", "Which tense dominates a Diary Entry recounting today's event?", listOf("Simple Past", "Future Continuous", "Present Perfect Continuous", "Imperative"), 0, "Events that happened earlier in the day are narrated in Simple Past.")
        )
    ),

    // CLASS 10 (BOARD PREP)
    ClassSubjectSeed(
        10, SubjectType.MATH,
        "Quadratic Equations & Trigonometry",
        "Solve quadratics using the Quadratic Formula and master sine, cosine, tangent ratios for Board exams.",
        listOf("Quadratic Formula: x = [-b ± √(b² - 4ac)] / 2a; Discriminant D = b² - 4ac.", "D > 0 ⇒ 2 distinct real roots; D = 0 ⇒ equal roots; D < 0 ⇒ no real roots.", "Trig values: sin 30° = 1/2, sin 45° = 1/√2, sin 60° = √3/2, tan 45° = 1."),
        "sin²θ + cos²θ = 1  |  1 + tan²θ = sec²θ  |  x = (-b ± √D)/2a",
        "Arithmetic Progressions & Circles",
        "Find nth terms and sums of AP sequences and apply tangent theorems on circles.",
        listOf("nth term of AP: aₙ = a + (n - 1)d.", "Sum of n terms: Sₙ = (n/2)[2a + (n - 1)d].", "Tangent to a circle is perpendicular to the radius at the point of contact; tangents from an external point are equal."),
        "aₙ = a + (n-1)d   |   Sₙ = (n/2)(a + l)   |   Tangent ⊥ Radius",
        listOf(
            q("c10m1", "If discriminant D = b² - 4ac = 0, the quadratic equation has:", listOf("No real roots", "Two distinct real roots", "Two equal real roots", "Three roots"), 2, "When D = 0, both roots equal -b/2a."),
            q("c10m2", "What is the value of sin² 30° + cos² 30°?", listOf("0", "1/2", "1", "√3/2"), 2, "By fundamental identity, sin²θ + cos²θ = 1 for any angle θ."),
            q("c10m3", "Find the 10th term of the AP: 2, 5, 8, 11, ...", listOf("27", "29", "31", "32"), 1, "a = 2, d = 3 ⇒ a₁₀ = 2 + 9(3) = 29."),
            q("c10m4", "How many tangents can be drawn from an external point to a circle?", listOf("0", "1", "2", "Infinite"), 2, "Exactly two equal tangents can be drawn from an external point.")
        )
    ),
    ClassSubjectSeed(
        10, SubjectType.SCIENCE,
        "Chemical Reactions, Carbon & Metals",
        "Balance equations, compare reactivity series, and learn homologous series of Carbon compounds.",
        listOf("Oxidation = gain of oxygen / loss of electrons; Reduction = loss of oxygen / gain of electrons.", "Alkanes: CₙH₂ₙ₊₂; Alkenes: CₙH₂ₙ; Alkynes: CₙH₂ₙ₋₂.", "Amphoteric oxides (Al₂O₃, ZnO) react with both acids and bases."),
        "CₙH₂ₙ₊₂ (Alkane) | Ethanoic Acid + Ethanol ⇌ Ester + H₂O",
        "Electricity, Magnetism & Life Processes",
        "Apply Ohm's Law, series/parallel resistance formulas, and human circulation & photosynthesis.",
        listOf("Ohm's Law: V = IR; Power P = VI = I²R = V²/R.", "Series: R = R₁ + R₂; Parallel: 1/R = 1/R₁ + 1/R₂.", "Photosynthesis: 6CO₂ + 6H₂O → C₆H₁₂O₆ + 6O₂ (in chlorophyll & sunlight)."),
        "V = I × R   |   H = I²Rt   |   1/Rₚ = 1/R₁ + 1/R₂",
        listOf(
            q("c10s1", "What is the general formula of Alkenes?", listOf("CₙH₂ₙ₊₂", "CₙH₂ₙ", "CₙH₂ₙ₋₂", "CₙHₙ"), 1, "Alkenes contain a C=C double bond and follow CₙH₂ₙ."),
            q("c10s2", "Two resistors of 4 Ω and 4 Ω are connected in parallel. Equivalent resistance is:", listOf("8 Ω", "4 Ω", "2 Ω", "1 Ω"), 2, "1/R = 1/4 + 1/4 = 2/4 ⇒ R = 2 Ω."),
            q("c10s3", "Which gas is released during photosynthesis?", listOf("Carbon dioxide", "Nitrogen", "Oxygen", "Hydrogen"), 2, "Plants release oxygen by splitting water molecules."),
            q("c10s4", "What is the SI unit of electrical resistance?", listOf("Volt", "Ampere", "Ohm (Ω)", "Watt"), 2, "Resistance R = V/I is measured in Ohms (Ω).")
        )
    ),
    ClassSubjectSeed(
        10, SubjectType.HINDI,
        "रस परिचय व वाच्य परिवर्तन",
        "बोर्ड परीक्षा हेतु शृंगार, वीर, करुण व हास्य रस के स्थायी भाव तथा कर्तृवाच्य, कर्मवाच्य और भाववाच्य सीखें।",
        listOf("रस के 4 अंग: स्थायी भाव, विभाव, अनुभाव, संचारी भाव।", "रति (शृंगार), उत्साह (वीर), शोक (करुण), हास (हास्य)।", "कर्तृवाच्य में कर्ता प्रधान; कर्मवाच्य में 'के द्वारा' व कर्म प्रधान; भाववाच्य में असमर्थता/भाव।"),
        "वीर रस → उत्साह  |  करुण रस → शोक  |  राम ने पत्र लिखा → राम के द्वारा पत्र लिखा गया",
        "सूरदास के पद एवं तुलसीदास (राम-लक्ष्मण संवाद)",
        "भक्ति और वीर काव्य की व्याख्या, अलंकार और बोर्ड परीक्षा हेतु संपादकीय पत्र प्रारूप समझें।",
        listOf("सूरदास के 'भ्रमरगीत' में गोपियों का श्रीकृष्ण के प्रति अनन्य प्रेम व उद्धव पर व्यंग्य है।", "तुलसीदास के राम-लक्ष्मण-परशुराम संवाद में अवधि भाषा और चौपाई-दोहा छंद हैं।", "औपचारिक पत्र में विषय, सटीक कारण व विनम्र समापन अनिवार्य है।"),
        "चौपाई (16 मात्राएँ) व दोहा छंद | ब्रजभाषा (सूरदास) | अवधी (तुलसीदास)",
        listOf(
            q("c10h1", "'वीर रस' का स्थायी भाव क्या होता है?", listOf("शोक", "रति", "उत्साह", "क्रोध"), 2, "वीर रस का स्थायी भाव 'उत्साह' है।"),
            q("c10h2", "'पक्षी से उड़ा नहीं जाता।' में कौन-सा वाच्य है?", listOf("कर्तृवाच्य", "कर्मवाच्य", "भाववाच्य", "कोई नहीं"), 2, "अकर्मक क्रिया व असमर्थता भाव के कारण यह भाववाच्य है।"),
            q("c10h3", "सूरदास के पद किस भाषा में रचित हैं?", listOf("अवधी", "ब्रजभाषा", "खड़ी बोली", "मैथिली"), 1, "सूरदास ने अपनी रचनाएँ ब्रजभाषा में कीं।"),
            q("c10h4", "'मुझसे यह भार उठाया गया।' वाक्य का वाच्य है:", listOf("कर्तृवाच्य", "कर्मवाच्य", "भाववाच्य", "मिश्र"), 1, "'भार' कर्म की प्रधानता और सकर्मक क्रिया के कारण कर्मवाच्य है।")
        )
    ),
    ClassSubjectSeed(
        10, SubjectType.ENGLISH,
        "Analytical Paragraph & Formal Letters",
        "Score full marks in CBSE Writing: Letter to the Editor, Complaint/Enquiry Letters, and Data Analysis.",
        listOf("Letter to Editor: Sender's Address → Date → The Editor → Subject → Salutation → 3 Paragraphs → Yours truly.", "Analytical Paragraph interprets charts/tables objectively in 100–120 words without personal opinion.", "Use comparative connectors: whereas, in contrast, overall, steadily rose."),
        "Editor Letter: Highlight issue → Impact → Constructive Suggestion",
        "Board Grammar: Modals, Tenses & Reported Speech",
        "Eliminate common gap-filling and error-correction mistakes in CBSE Board exams.",
        listOf("Present Perfect (has/have + V3) links past action to present result.", "With 'If + Simple Present', main clause uses 'will + V1' (First Conditional).", "Check subject–verb agreement carefully inside relative clauses."),
        "If + V1, will + V1   |   had + V3 before past event",
        listOf(
            q("c10e1", "Complete the conditional: If it rains tomorrow, we ___ cancel the match.", listOf("would", "will", "had", "were"), 1, "Type 1 conditional pairs simple present with 'will + base verb'."),
            q("c10e2", "In an Analytical Paragraph, you should:", listOf("Add personal stories", "State trends objectively from given data", "Write a poem", "Use slang"), 1, "Analytical paragraphs summarize charts/data factually."),
            q("c10e3", "Choose the correct form: By the time we arrived, the train ___.", listOf("has left", "had left", "leaves", "was leave"), 1, "The earlier of two past actions takes Past Perfect ('had left')."),
            q("c10e4", "Standard complimentary close for a Letter to the Editor is:", listOf("Yours lovingly", "Yours truly", "See you soon", "Best buddy"), 1, "Formal letters end with 'Yours truly' or 'Yours sincerely'.")
        )
    ),

    // CLASS 11
    ClassSubjectSeed(
        11, SubjectType.MATH,
        "Sets, Relations, Functions & Permutations",
        "Master Venn diagrams, domain & range of functions, and nPr / nCr counting techniques.",
        listOf("n(A ∪ B) = n(A) + n(B) - n(A ∩ B).", "A relation is a function if every input in the domain has exactly one output.", "nPr = n! / (n - r)! (order matters); nCr = n! / [r!(n - r)!] (selection)."),
        "n(A ∪ B) = n(A) + n(B) - n(A ∩ B)   |   ⁿCᵣ = ⁿCₙ₋ᵣ",
        "Straight Lines, Conics & Limits",
        "Use slope-point equations, circles/parabolas, and evaluate foundational calculus limits.",
        listOf("Slope m = (y₂ - y₁)/(x₂ - x₁); Two lines are ⊥ if m₁·m₂ = -1.", "Distance of point (x₁,y₁) from Ax + By + C = 0 is |Ax₁ + By₁ + C| / √(A² + B²).", "Standard limits: lim(x→0) (sin x)/x = 1; d/dx(xⁿ) = n·xⁿ⁻¹."),
        "lim(x→0) sin(x)/x = 1   |   y - y₁ = m(x - x₁)",
        listOf(
            q("c11m1", "If n(A) = 20, n(B) = 30, and n(A ∩ B) = 10, find n(A ∪ B):", listOf("40", "50", "60", "30"), 0, "20 + 30 - 10 = 40."),
            q("c11m2", "What is the value of ⁵C₂?", listOf("5", "10", "20", "25"), 1, "5! / (2!·3!) = (5×4)/2 = 10."),
            q("c11m3", "Two lines with slopes m₁ = 2 and m₂ = -1/2 are:", listOf("Parallel", "Perpendicular", "Coincident", "Skew"), 1, "m₁ × m₂ = 2 × (-1/2) = -1, so they are perpendicular."),
            q("c11m4", "Find d/dx (x⁴):", listOf("4x⁴", "4x³", "x³/4", "4x"), 1, "Power rule: n·xⁿ⁻¹ = 4x³.")
        )
    ),
    ClassSubjectSeed(
        11, SubjectType.SCIENCE,
        "Kinematics, Work–Energy & Thermodynamics",
        "Apply equations of motion, Work–Energy Theorem, and First Law of Thermodynamics.",
        listOf("v = u + at;  s = ut + ½at²;  v² - u² = 2as.", "Work-Energy Theorem: Net Work Done = Change in Kinetic Energy (½mv² - ½mu²).", "First Law of Thermodynamics: ΔQ = ΔU + ΔW (conservation of energy)."),
        "v² = u² + 2as   |   KE = ½mv²   |   ΔQ = ΔU + PΔV",
        "Chemical Bonding & Equilibrium",
        "Predict molecular shapes with VSEPR, hybridisation (sp, sp², sp³), and Le Chatelier's Principle.",
        listOf("CH₄ is tetrahedral (sp³, 109.5°); BF₃ is trigonal planar (sp², 120°); BeCl₂ is linear (sp, 180°).", "pH = -log₁₀[H⁺]; pH + pOH = 14 at 298 K.", "Le Chatelier: Equilibrium shifts to oppose any change in concentration, pressure, or temperature."),
        "sp³ → 109.5° | sp² → 120° | pH = -log[H⁺]",
        listOf(
            q("c11s1", "Area under a velocity-time graph gives:", listOf("Acceleration", "Displacement", "Force", "Momentum"), 1, "Integrating velocity over time yields displacement."),
            q("c11s2", "What is the hybridisation of carbon in methane (CH₄)?", listOf("sp", "sp²", "sp³", "dsp²"), 2, "4 sigma bonds and 0 lone pairs give sp³ tetrahedral geometry."),
            q("c11s3", "At 298 K, a neutral aqueous solution has pH equal to:", listOf("0", "5", "7", "14"), 2, "[H⁺] = 10⁻⁷ M gives pH = 7."),
            q("c11s4", "In First Law ΔQ = ΔU + ΔW, ΔU stands for change in:", listOf("Entropy", "Internal Energy", "Pressure", "Specific Heat"), 1, "ΔU represents internal energy change of the system.")
        )
    ),
    ClassSubjectSeed(
        11, SubjectType.HINDI,
        "काव्य सौंदर्य एवं जनसंचार माध्यम",
        "मीराबाई और भवानीप्रसाद मिश्र के काव्य-सौंदर्य तथा पत्रकारिता व जनसंचार के सिद्धांतों का अध्ययन करें।",
        listOf("भाव पक्ष (मूल संवेदना/रस) और कला पक्ष (भाषा, छंद, अलंकार, बिंब) काव्य सौंदर्य के दो स्तंभ हैं।", "जनसंचार के प्रमुख माध्यम: प्रिंट (अखबार), इलेक्ट्रॉनिक (टीवी/रेडियो) और न्यू मीडिया (इंटरनेट)।", "समाचार लेखन की सबसे लोकप्रिय शैली 'उल्टा पिरामिड शैली' (Inverted Pyramid) है।"),
        "उल्टा पिरामिड शैली: मुखड़ा (Intro) → बॉडी → समापन",
        "कार्यालयी पत्र एवं फीचर लेखन",
        "आधिकारिक पत्राचार, प्रेस विज्ञप्ति और रोचक फीचर लेखन के अंतर व प्रारूप को समझें।",
        listOf("समाचार में 'कब, कहाँ, क्या, कौन, क्यों, कैसे' (छह ककार) का उत्तर होता है।", "फीचर सुव्यवस्थित, सृजनात्मक और आत्मनिष्ठ लेखन है जो पाठकों का मनोरंजन व ज्ञानवर्धन करता है।", "सरकारी पत्र में पत्रांक, दिनांक, प्रेषक, प्रेषिती व विषय स्पष्ट होते हैं।"),
        "6 ककार: क्या • कौन • कहाँ • कब • क्यों • कैसे",
        listOf(
            q("c11h1", "समाचार लेखन की मुख्य शैली कौन-सी है?", listOf("सीधा पिरामिड", "उल्टा पिरामिड", "कथात्मक", "नाटकीय"), 1, "सबसे महत्वपूर्ण तथ्य सबसे पहले 'उल्टा पिरामिड' शैली में रखे जाते हैं।"),
            q("c11h2", "समाचार लेखन में कितने 'ककार' होते हैं?", listOf("4", "5", "6", "8"), 2, "क्या, कौन, कहाँ, कब, क्यों और कैसे—कुल 6 ककार होते हैं।"),
            q("c11h3", "'मुखड़ा (इंट्रो)' समाचार के किस भाग में आता है?", listOf("अंत में", "मध्य में", "आरंभ में", "शीर्षक के बाद नहीं"), 2, "उल्टा पिरामिड के सबसे ऊपर मुख्य सार यानी मुखड़ा होता है।"),
            q("c11h4", "भारत में पहला हिंदी समाचार पत्र कौन-सा था?", listOf("हंस", "उदंत मार्तंड", "सरस्वती", "केसरी"), 1, "1826 में जुगल किशोर शुक्ल द्वारा 'उदंत मार्तंड' प्रकाशित हुआ।")
        )
    ),
    ClassSubjectSeed(
        11, SubjectType.ENGLISH,
        "Note-Making & Summary Skills",
        "Extract hierarchical main points using indentation, standard abbreviations, and concise summaries.",
        listOf("Never copy full sentences in Note-Making—use short phrases & recognizable abbreviations.", "Format: Title → Numbered Headings (1., 1.1, 1.2) → Key to Abbreviations box → Summary (50–80 words).", "Keep 4–6 standard abbreviations like Govt., Edu., & (and), info."),
        "Note-Making = Title + Headings (1.1, 1.2) + Abbrev. Key + Summary",
        "Posters, Classified Ads & Debate",
        "Design punchy visual posters and write persuasive pro/con debate speeches.",
        listOf("Poster: Catchy slogan, bold visual cue, event details, issuing authority—all in a box.", "Debate starts with formal salutation ('Honourable Jury...') and clearly takes ONE side (For or Against).", "Use rhetorical questions and statistics to strengthen arguments."),
        "Debate: Greeting → Clear Stance → 3 Evidence Points → Conclusion",
        listOf(
            q("c11e1", "In Note-Making, which element must accompany shortened words?", listOf("Bibliography", "Key to Abbreviations", "Index", "Footnote"), 1, "A 4–6 word Key to Abbreviations box explains all symbols used."),
            q("c11e2", "What is the golden rule of a Debate speech?", listOf("Support both sides equally", "Take one clear stance: For or Against", "Avoid addressing the jury", "Write in bullet points"), 1, "Debaters argue decisively for or against the motion."),
            q("c11e3", "A Classified Advertisement should avoid:", listOf("Contact details", "Full literary paragraphs", "Word limit", "Clear heading"), 1, "Classifieds use crisp phrases within ~50 words."),
            q("c11e4", "Which is a standard acceptable abbreviation in Note-Making?", listOf("abcde", "Govt.", "x9", "zzzz"), 1, "'Govt.' is a universally understood standard abbreviation.")
        )
    ),

    // CLASS 12 (SENIOR SECONDARY)
    ClassSubjectSeed(
        12, SubjectType.MATH,
        "Matrices, Determinants & Calculus",
        "Invert matrices, solve linear systems, and master differentiation & integration rules for Class 12 Boards.",
        listOf("A square matrix A is invertible iff |A| ≠ 0; A⁻¹ = adj(A) / |A|.", "Chain Rule: d/dx[f(g(x))] = f'(g(x)) · g'(x); Product Rule: (uv)' = u'v + uv'.", "Integration by parts: ∫u·v dx = u∫v dx - ∫(u'∫v dx)dx (ILATE rule)."),
        "A⁻¹ = adj(A)/|A|   |   ∫eˣ[f(x) + f'(x)]dx = eˣf(x) + C",
        "Vectors, 3D Geometry & Probability",
        "Compute dot & cross products, shortest distance between skew lines, and apply Bayes' Theorem.",
        listOf("Dot product a·b = |a||b|cosθ (0 if ⊥); Cross product |a×b| = |a||b|sinθ.", "Direction cosines satisfy l² + m² + n² = 1.", "Bayes' Theorem updates conditional probability P(Eᵢ|A) using prior & likelihoods."),
        "l² + m² + n² = 1   |   P(A|B) = P(A ∩ B) / P(B)",
        listOf(
            q("c12m1", "A square matrix A is singular when:", listOf("|A| = 1", "|A| = 0", "A = Aᵀ", "|A| > 0"), 1, "When determinant |A| = 0, A is singular and has no inverse."),
            q("c12m2", "What is ∫(1/x) dx?", listOf("x²/2 + C", "log|x| + C", "-1/x² + C", "eˣ + C"), 1, "The antiderivative of 1/x is ln|x| + C."),
            q("c12m3", "If two vectors a and b are perpendicular, their dot product a·b is:", listOf("1", "-1", "0", "|a||b|"), 2, "cos 90° = 0, so a·b = 0."),
            q("c12m4", "If l, m, n are direction cosines of a line, then l² + m² + n² =", listOf("0", "1", "2", "3"), 1, "Sum of squares of direction cosines always equals 1.")
        )
    ),
    ClassSubjectSeed(
        12, SubjectType.SCIENCE,
        "Electrostatics, Magnetism & Optics",
        "Apply Gauss's Law, Kirchhoff's rules, Faraday's EMI, and Lens Maker's Formula.",
        listOf("Gauss's Law: Electric flux Φ = q_enclosed / ε₀.", "Faraday's Law: Induced EMF e = -dΦ_B / dt (Lenz's Law opposes cause).", "Lens Maker's Formula: 1/f = (μ - 1)(1/R₁ - 1/R₂)."),
        "Φ = q/ε₀   |   e = -dΦ/dt   |   1/f = 1/v - 1/u",
        "Biomolecules, Genetics & Electrochemistry",
        "Master Nernst Equation, DNA replication (semi-conservative), and Central Dogma.",
        listOf("Nernst Equation: E_cell = E°_cell - (0.0591/n) log Q at 298 K.", "Central Dogma: DNA → (Transcription) → mRNA → (Translation) → Protein.", "DNA bases pair specifically: Adenine–Thymine (2 H-bonds), Guanine–Cytosine (3 H-bonds)."),
        "A = T, G ≡ C   |   E_cell = E° - (0.059/n) log Q",
        listOf(
            q("c12s1", "What is the SI unit of electric flux?", listOf("N/C", "N·m²/C", "Volt/m", "Tesla"), 1, "Flux Φ = E·A has units (N/C)·m² = N·m²/C."),
            q("c12s2", "Lenz's Law is a direct consequence of conservation of:", listOf("Charge", "Mass", "Energy", "Angular momentum"), 2, "Induced EMF opposes the flux change, conserving mechanical/electrical energy."),
            q("c12s3", "In DNA, Adenine pairs with:", listOf("Guanine", "Cytosine", "Thymine", "Uracil"), 2, "In DNA, A pairs with T and G pairs with C (Uracil is in RNA)."),
            q("c12s4", "Synthesis of mRNA from a DNA template is called:", listOf("Replication", "Transcription", "Translation", "Mutation"), 1, "Transcription copies genetic code from DNA into mRNA.")
        )
    ),
    ClassSubjectSeed(
        12, SubjectType.HINDI,
        "आधुनिक काव्य (हरिवंशराय बच्चन व निराला) एवं गद्य",
        "आत्मपरिचय, पतंग व भक्तिन जैसे प्रमुख पाठों का मर्म और बोर्ड प्रश्नोत्तर रणनीति सीखें।",
        listOf("हरिवंशराय बच्चन की 'आत्मपरिचय' कविता में दुनिया से खट्टे-मीठे रिश्ते और प्रेम-संदेश की झलक है।", "महादेवी वर्मा का 'भक्तिन' संस्मरण ग्रामीण नारी के संघर्ष और स्वाभिमान का जीवंत चित्र है।", "बोर्ड उत्तरों में पाठ का संदर्भ, मुख्य तर्क व सटीक उदाहरण अवश्य लिखें।"),
        "काव्य समीक्षा = भाव-सौंदर्य + शिल्प-सौंदर्य + प्रासंगिकता",
        "रचनात्मक लेखन व नए-अप्रत्याशित विषय",
        "कक्षा 12 बोर्ड परीक्षा के लिए अप्रत्याशित विषय पर निबंध/लेख और नाटक-कहानी के तत्व समझें।",
        listOf("रचनात्मक लेखन में भूमिका रोचक हो, मध्य में विविध दृष्टिकोण हों और अंत सकारात्मक हो।", "कहानी के प्रमुख तत्व: कथानक, पात्र, संवाद, देश-काल, भाषा-शैली व उद्देश्य।", "अशुद्ध वर्तनी से बचें और छोटे, सधे हुए वाक्य लिखें।"),
        "कहानी = कथानक • पात्र • संवाद • वातावरण • उद्देश्य",
        listOf(
            q("c12h1", "'आत्मपरिचय' कविता के रचनाकार कौन हैं?", listOf("रामधारी सिंह दिनकर", "हरिवंशराय बच्चन", "सूर्यकांत त्रिपाठी निराला", "सुमित्रानंदन पंत"), 1, "'आत्मपरिचय' हरिवंशराय बच्चन के काव्य संग्रह 'निशा निमंत्रण' से है।"),
            q("c12h2", "'भक्तिन' पाठ किस विधा की रचना है?", listOf("कहानी", "संस्मरण / रेखाचित्र", "एकांकी", "जीवनी"), 1, "महादेवी वर्मा द्वारा रचित 'भक्तिन' एक संस्मरणात्मक रेखाचित्र है।"),
            q("c12h3", "कहानी के तत्वों में से इनमें कौन शामिल है?", listOf("केवल शीर्षक", "कथानक व चरित्र-चित्रण", "विज्ञापन", "अनुक्रमणिका"), 1, "कथानक, पात्र और संवाद कहानी के मूल तत्व हैं।"),
            q("c12h4", "'निशा निमंत्रण' किस कवि की प्रसिद्ध कृति है?", listOf("हरिवंशराय बच्चन", "जयशंकर प्रसाद", "कबीर", "तुलसीदास"), 0, "यह हरिवंशराय बच्चन का प्रसिद्ध गीत-संग्रह है।")
        )
    ),
    ClassSubjectSeed(
        12, SubjectType.ENGLISH,
        "Job Applications & Formal Invitations",
        "Master CBSE Class 12 Writing: Cover Letter + Bio-data/Resume and Formal/Informal Invitations & Replies.",
        listOf("Job Application = Formal Cover Letter (1 page) + Structured Bio-data (Name, Qualification, Experience, References).", "Formal Printed Invitation uses third person, single sentence, centered layout inside a box.", "Formal Reply of Acceptance/Refusal also stays in third person with polite thanks."),
        "Invitation: Host + Requests the pleasure of + Event + Date/Time/Venue + RSVP",
        "Flamingo & Vistas Literary Devices",
        "Analyze poetic devices (metaphor, alliteration, transferred epithet, irony) for extract-based questions.",
        listOf("Simile uses 'like/as'; Metaphor implies direct equivalence.", "Transferred Epithet shifts an adjective to an adjacent noun ('selfish cars').", "Always cite textual evidence and theme in 120–150 word long answers."),
        "Simile (like/as) | Metaphor (direct) | Irony (contrast)",
        listOf(
            q("c12e1", "A printed Formal Invitation card is always written in which person?", listOf("First person (I/We)", "Second person (You)", "Third person (He/She/They)", "Imperative only"), 2, "Standard formal invitations are written in third person."),
            q("c12e2", "What must accompany a formal Job Application letter?", listOf("Poem", "Bio-data / Resume", "Notice box", "Poster"), 1, "A structured Bio-data / CV accompanies the cover letter."),
            q("c12e3", "Identify the poetic device in 'trees sprinting' (My Mother at Sixty-Six):", listOf("Personification", "Oxymoron", "Pun", "Hyperbole"), 0, "Giving human action 'sprinting' to trees is personification."),
            q("c12e4", "In 'The Last Lesson', what theme does Franz's regret highlight?", listOf("Value of one's mother tongue & not procrastinating", "Space travel", "Industrialisation", "Sportsmanship"), 0, "Alphonse Daudet highlights linguistic pride and valuing learning before it is lost.")
        )
    )
)
