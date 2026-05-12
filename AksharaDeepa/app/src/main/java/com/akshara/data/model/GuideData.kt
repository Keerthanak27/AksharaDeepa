package com.akshara.data.model

object GuideData {
    private val guides = mapOf(
        // SCIENCE (1-10)
        1 to StudyGuide("Science", "Chemical Reactions and Equations", listOf(
            StudyGuideSection("Chemical Equations", "🧪", "A chemical equation represents a chemical reaction using symbols and formulas. It must be balanced to satisfy the Law of Conservation of Mass."),
            StudyGuideSection("Types of Reactions", "⚗️", "1. Combination: Two reactants form one product. 2. Decomposition: One reactant breaks into multiple products. 3. Displacement: More reactive element displaces less reactive one. 4. Double Displacement: Exchange of ions. 5. Redox: Simultaneous oxidation and reduction."),
            StudyGuideSection("Corrosion & Rancidity", "⛓️", "Corrosion is the gradual destruction of metals by air/moisture (e.g., rusting). Rancidity is the oxidation of fats and oils in food, causing bad smell and taste.")
        )),
        2 to StudyGuide("Science", "Acids, Bases and Salts", listOf(
            StudyGuideSection("Indicators", "🌡️", "Litmus, Methyl Orange, and Phenolphthalein are used to test acidity/basicity. Natural indicators include Turmeric and Red Cabbage."),
            StudyGuideSection("pH Scale", "📉", "Measures H+ ion concentration. pH < 7 is acidic, pH = 7 is neutral, pH > 7 is basic. Importance: pH in digestive system, tooth decay (starts at pH < 5.5)."),
            StudyGuideSection("Important Salts", "🧂", "Common Salt (NaCl), Bleaching Powder (CaOCl2), Baking Soda (NaHCO3), Washing Soda (Na2CO3.10H2O), and Plaster of Paris (CaSO4.1/2H2O).")
        )),
        3 to StudyGuide("Science", "Metals and Non-metals", listOf(
            StudyGuideSection("Physical Properties", "🔨", "Metals: Malleable, ductile, lustrous, good conductors. Non-metals: Brittle, non-lustrous (except Iodine), poor conductors (except Graphite)."),
            StudyGuideSection("Chemical Properties", "🔥", "Metals react with oxygen to form basic oxides. They react with water and acids (releasing H2). Non-metals form acidic or neutral oxides."),
            StudyGuideSection("Metallurgy", "⛏️", "Extraction of metals from ores. Steps: Enrichment, Reduction, and Refining. Alloys: Brass (Cu+Zn), Bronze (Cu+Sn), Solder (Pb+Sn).")
        )),
        4 to StudyGuide("Science", "Carbon and its Compounds", listOf(
            StudyGuideSection("Covalent Bonding", "⚛️", "Carbon forms covalent bonds by sharing electrons. It shows tetravalency and catenation (forming long chains)."),
            StudyGuideSection("Hydrocarbons", "⛽", "Saturated (Alkanes, single bonds) and Unsaturated (Alkenes/Alkynes, double/triple bonds). Homologous series: Same functional group, differing by -CH2."),
            StudyGuideSection("Soaps & Detergents", "🧼", "Soaps are sodium/potassium salts of long chain fatty acids. Micelle formation helps in cleaning. Detergents work even in hard water.")
        )),
        5 to StudyGuide("Science", "Life Processes", listOf(
            StudyGuideSection("Nutrition", "🍎", "Autotrophic (Photosynthesis) and Heterotrophic (Holozoic, Saprophytic, Parasitic). Digestion in humans involves mouth, stomach, small intestine (absorption)."),
            StudyGuideSection("Respiration", "🫁", "Aerobic (with O2, in mitochondria) and Anaerobic (without O2, in cytoplasm/yeast/muscle cells). Human respiratory system: Alveoli for gas exchange."),
            StudyGuideSection("Transportation & Excretion", "🩸", "Heart as pump, double circulation. Xylem (water) and Phloem (food) in plants. Nephron is the filtration unit of the kidney.")
        )),
        6 to StudyGuide("Science", "Control and Coordination", listOf(
            StudyGuideSection("Nervous System", "🧠", "Neuron structure (Dendrite, Axon, Synapse). Central Nervous System (Brain, Spinal Cord) and Peripheral Nervous System."),
            StudyGuideSection("Reflex Action", "⚡", "Sudden, involuntary response to stimulus. Reflex arc: Receptor -> Sensory neuron -> Spinal cord -> Motor neuron -> Effector."),
            StudyGuideSection("Hormones", "🧪", "Plant hormones: Auxin, Gibberellin, Cytokinin, Abscisic acid. Animal hormones: Insulin, Adrenaline, Thyroxine, Growth hormone.")
        )),
        7 to StudyGuide("Science", "How do Organisms Reproduce?", listOf(
            StudyGuideSection("Asexual Reproduction", "🧬", "Fission (Amoeba), Budding (Yeast, Hydra), Fragmentation (Spirogyra), Regeneration (Planaria), Spore formation (Rhizopus)."),
            StudyGuideSection("Sexual Reproduction", "🌸", "In Flowering Plants: Pollination (Self/Cross), Fertilization. In Humans: Male and Female reproductive systems, Puberty, Fertilization, Embryo development."),
            StudyGuideSection("Reproductive Health", "🏥", "Contraception methods (Barrier, Chemical, IUCDs, Surgical). Importance of preventing STDs (HIV/AIDS, Gonorrhoea, Syphilis).")
        )),
        8 to StudyGuide("Science", "Heredity and Evolution", listOf(
            StudyGuideSection("Mendel's Laws", "🌱", "Monohybrid cross (3:1 ratio) and Dihybrid cross (9:3:3:1 ratio). Law of Dominance and Law of Independent Assortment."),
            StudyGuideSection("Sex Determination", "🚻", "In humans, sex is determined by the father (X or Y chromosome). XX is female, XY is male."),
            StudyGuideSection("Evolution", "🐒", "Speciation due to genetic drift, natural selection, or geographical isolation. Homologous vs Analogous organs. Fossils as evidence.")
        )),
        9 to StudyGuide("Science", "Light: Reflection and Refraction", listOf(
            StudyGuideSection("Reflection", "🪞", "Laws of reflection. Spherical mirrors: Concave (converging) and Convex (diverging). Mirror formula: 1/f = 1/v + 1/u. Magnification."),
            StudyGuideSection("Refraction", "💎", "Laws of refraction (Snell's Law). Refractive index. Lenses: Convex (converging) and Concave (diverging). Lens formula: 1/f = 1/v - 1/u."),
            StudyGuideSection("Power of Lens", "👓", "P = 1/f (in meters). Unit: Dioptre (D). Power is positive for convex lens and negative for concave lens.")
        )),
        10 to StudyGuide("Science", "Human Eye and Colourful World", listOf(
            StudyGuideSection("Eye Defects", "👁️", "Myopia (Nearsightedness, fixed by concave), Hypermetropia (Farsightedness, fixed by convex), Presbyopia."),
            StudyGuideSection("Prism & Dispersion", "🌈", "Splitting of white light into VIBGYOR. Rainbow formation involves dispersion, refraction, and internal reflection."),
            StudyGuideSection("Atmospheric Phenomena", "⭐", "Twinkling of stars (refraction), Advanced sunrise/Delayed sunset, Blue color of sky (Scattering/Tyndall effect).")
        )),

        // MATHEMATICS (11-20)
        11 to StudyGuide("Mathematics", "Real Numbers", listOf(
            StudyGuideSection("Fundamental Theorem", "🔢", "Every composite number can be expressed as a product of primes uniquely. HCF × LCM = Product of two numbers."),
            StudyGuideSection("Irrational Numbers", "🧮", "Proof of irrationality for √2, √3, √5. A number is irrational if its decimal expansion is non-terminating and non-repeating."),
            StudyGuideSection("Decimal Expansions", "小数", "Terminating if denominator is of form 2^n * 5^m. Otherwise, it is non-terminating repeating.")
        )),
        12 to StudyGuide("Mathematics", "Polynomials", listOf(
            StudyGuideSection("Zeroes", "0️⃣", "Geometrical meaning: Number of zeroes is the number of times the graph intersects the x-axis."),
            StudyGuideSection("Coefficients", "✖️", "For ax² + bx + c: Sum of zeroes (α+β) = -b/a. Product of zeroes (αβ) = c/a."),
            StudyGuideSection("Cubic Polynomials", "🧊", "For ax³ + bx² + cx + d: Sum = -b/a, Sum of products = c/a, Product = -d/a.")
        )),
        13 to StudyGuide("Mathematics", "Pair of Linear Equations", listOf(
            StudyGuideSection("Graphical Method", "📈", "Intersecting lines (Unique solution), Parallel lines (No solution), Coincident lines (Infinite solutions)."),
            StudyGuideSection("Algebraic Methods", "📝", "1. Substitution: Express one variable in terms of another. 2. Elimination: Make coefficients equal to remove one variable."),
            StudyGuideSection("Consistency", "✅", "Consistent: At least one solution. Inconsistent: No solution.")
        )),
        14 to StudyGuide("Mathematics", "Quadratic Equations", listOf(
            StudyGuideSection("Standard Form", "📐", "ax² + bx + c = 0, where a ≠ 0. Solutions can be found by Factorization or Quadratic Formula."),
            StudyGuideSection("Quadratic Formula", "➗", "x = [-b ± √(b² - 4ac)] / 2a. The term b² - 4ac is called the Discriminant (D)."),
            StudyGuideSection("Nature of Roots", "🔍", "D > 0: Two distinct real roots. D = 0: Two equal real roots. D < 0: No real roots.")
        )),
        15 to StudyGuide("Mathematics", "Arithmetic Progressions", listOf(
            StudyGuideSection("nth Term", "🔢", "an = a + (n - 1)d, where 'a' is the first term and 'd' is the common difference."),
            StudyGuideSection("Sum of n Terms", "➕", "Sn = n/2 [2a + (n - 1)d] OR Sn = n/2 [a + l], where 'l' is the last term."),
            StudyGuideSection("Applications", "🛠️", "Solving daily life problems involving fixed increments or savings.")
        )),
        16 to StudyGuide("Mathematics", "Triangles", listOf(
            StudyGuideSection("Similarity", "🔺", "Two triangles are similar if their corresponding angles are equal and corresponding sides are in the same ratio."),
            StudyGuideSection("Thales Theorem", "📏", "Basic Proportionality Theorem: If a line is parallel to one side of a triangle, it divides the other two sides proportionally."),
            StudyGuideSection("Pythagoras Theorem", "📐", "In a right triangle, Hypotenuse² = Base² + Altitude². Important for similar triangle areas.")
        )),
        17 to StudyGuide("Mathematics", "Coordinate Geometry", listOf(
            StudyGuideSection("Distance Formula", "📏", "Distance between (x1, y1) and (x2, y2) = √[(x2 - x1)² + (y2 - y1)²]."),
            StudyGuideSection("Section Formula", "✂️", "Coordinates of point P dividing AB in ratio m1:m2 = [(m1x2 + m2x1)/(m1+m2), (m1y2 + m2y1)/(m1+m2)]."),
            StudyGuideSection("Midpoint", "📍", "Midpoint of AB = [(x1+x2)/2, (y1+y2)/2]. Area of triangle formula is also used.")
        )),
        18 to StudyGuide("Mathematics", "Introduction to Trigonometry", listOf(
            StudyGuideSection("Ratios", "📐", "sin = P/H, cos = B/H, tan = P/B, cosec = H/P, sec = H/B, cot = B/P. (P: Perpendicular, B: Base, H: Hypotenuse)"),
            StudyGuideSection("Specific Angles", "🔢", "Values of sin, cos, tan for 0°, 30°, 45°, 60°, 90°. For example, sin 30° = 1/2, cos 45° = 1/√2."),
            StudyGuideSection("Identities", "🆔", "1. sin²θ + cos²θ = 1. 2. 1 + tan²θ = sec²θ. 3. 1 + cot²θ = cosec²θ.")
        )),
        19 to StudyGuide("Mathematics", "Circles", listOf(
            StudyGuideSection("Tangents", "⭕", "A line that intersects the circle at exactly one point. The tangent is perpendicular to the radius through the point of contact."),
            StudyGuideSection("External Points", "📍", "From an external point, exactly two tangents can be drawn to a circle. Their lengths are equal."),
            StudyGuideSection("Properties", "📏", "Angles between two tangents and the angle subtended by radii at the center are supplementary.")
        )),
        20 to StudyGuide("Mathematics", "Statistics", listOf(
            StudyGuideSection("Mean", "📊", "Direct Method: Σfixi / Σfi. Assumed Mean Method and Step Deviation Method are also used."),
            StudyGuideSection("Median", "📉", "Median = l + [(n/2 - cf) / f] × h. It is the middle-most value of the data."),
            StudyGuideSection("Mode", "🔝", "Mode = l + [(f1 - f0) / (2f1 - f0 - f2)] × h. It is the value with the highest frequency.")
        )),

        // SOCIAL STUDIES (21-30)
        21 to StudyGuide("Social Studies", "Rise of Nationalism in Europe", listOf(
            StudyGuideSection("French Revolution", "🇫🇷", "Spread the ideas of 'La Patrie' and 'Le Citoyen'. Napoleon's Civil Code (1804) abolished feudalism."),
            StudyGuideSection("Unifications", "🇮🇹", "Unification of Italy (Mazzini, Cavour, Garibaldi) and Germany (Bismarck, 'Blood and Iron' policy)."),
            StudyGuideSection("Imperialism", "🌍", "Nationalism aligned with imperialism led Europe to disaster in 1914 (WWI). Concepts of Balkan tensions.")
        )),
        22 to StudyGuide("Social Studies", "Nationalism in India", listOf(
            StudyGuideSection("Satyagraha", "🕊️", "Gandhiji's method of non-violent resistance. Early movements: Champaran, Kheda, Ahmedabad."),
            StudyGuideSection("Non-Cooperation", "🚫", "Launched in 1920, withdrawn after Chauri Chaura (1922). Included Khilafat movement."),
            StudyGuideSection("Civil Disobedience", "🧂", "Started with the Dandi Salt March (1930). Quit India Movement (1942) was the final push for independence.")
        )),
        23 to StudyGuide("Social Studies", "The Making of a Global World", listOf(
            StudyGuideSection("Silk Routes", "🧶", "Ancient trade links between Asia, Europe, and Africa. Shared goods, religion, and culture."),
            StudyGuideSection("19th Century", "🚢", "Mass migration, indentured labor (bonded labor), and the spread of diseases like Rinderpest in Africa."),
            StudyGuideSection("Bretton Woods", "🏦", "Post-war reconstruction. IMF and World Bank established to manage global economic stability.")
        )),
        24 to StudyGuide("Social Studies", "The Age of Industrialization", listOf(
            StudyGuideSection("Proto-industrialization", "🧵", "Large-scale production for international markets before the factory system."),
            StudyGuideSection("Factory System", "🏭", "Richard Arkwright's cotton mill. Shift from hand labor to steam power. Resistance to machines (Spinning Jenny)."),
            StudyGuideSection("Industrial India", "🇮🇳", "Early entrepreneurs (Tata, Birla). Shift from weaver-based production to mill-based production.")
        )),
        25 to StudyGuide("Social Studies", "Resources and Development", listOf(
            StudyGuideSection("Classification", "💎", "Biotic/Abiotic, Renewable/Non-renewable, Individual/Community/National/International."),
            StudyGuideSection("Planning", "📝", "Sustainable development and Agenda 21. Resource planning in India involves identification and inventory."),
            StudyGuideSection("Land & Soil", "🌱", "Alluvial, Black (Regur), Red/Yellow, Laterite, Arid, and Forest soils. Soil erosion and conservation.")
        )),
        26 to StudyGuide("Social Studies", "Forest and Wildlife Resources", listOf(
            StudyGuideSection("Biodiversity", "🐯", "India's rich flora and fauna. Classification of species: Normal, Endangered, Vulnerable, Rare, Endemic, Extinct."),
            StudyGuideSection("Conservation", "🌳", "Project Tiger (1973). Reserved, Protected, and Unclassed forests."),
            StudyGuideSection("Community Action", "🤝", "Chipko Movement, Beej Bachao Andolan, Joint Forest Management (JFM).")
        )),
        27 to StudyGuide("Social Studies", "Water Resources", listOf(
            StudyGuideSection("Scarcity", "💧", "Caused by over-exploitation and unequal access. Multipurpose projects (Dams) help in irrigation and power."),
            StudyGuideSection("Dams", "🏗️", "Dams as 'Temples of Modern India' (Nehru). Social movements: Narmada Bachao Andolan."),
            StudyGuideSection("Harvesting", "🌧️", "Rooftop rainwater harvesting (common in Rajasthan/Tamil Nadu). Gendathur village example.")
        )),
        28 to StudyGuide("Social Studies", "Agriculture", listOf(
            StudyGuideSection("Farming Types", "🚜", "Primitive Subsistence, Intensive Subsistence, and Commercial Farming."),
            StudyGuideSection("Cropping Pattern", "🌾", "Rabi (Winter), Kharif (Monsoon), and Zaid (Summer) seasons."),
            StudyGuideSection("Institutional Reforms", "🏛️", "Green Revolution, White Revolution (Operation Flood), and Land Reforms.")
        )),
        29 to StudyGuide("Social Studies", "Minerals and Energy Resources", listOf(
            StudyGuideSection("Minerals", "⛏️", "Ferrous (Iron, Manganese), Non-ferrous (Copper, Bauxite), and Non-metallic (Mica)."),
            StudyGuideSection("Conventional Energy", "🔥", "Coal, Petroleum, Natural Gas, and Electricity. Coal is the most abundant fossil fuel."),
            StudyGuideSection("Non-conventional", "☀️", "Solar, Wind, Biogas, Tidal, and Geothermal energy. Essential for sustainable future.")
        )),
        30 to StudyGuide("Social Studies", "Manufacturing Industries", listOf(
            StudyGuideSection("Importance", "🏭", "Backbone of economic development. Reduces dependence on agriculture and provides jobs."),
            StudyGuideSection("Location Factors", "📍", "Raw material availability, labor, capital, power, and market. Agglomeration economies."),
            StudyGuideSection("Pollution", "☁️", "Air, Water, Thermal, and Noise pollution. Need for environmental degradation control.")
        ))
    )

    fun getGuideForChapter(id: Int): StudyGuide? = guides[id]
}
