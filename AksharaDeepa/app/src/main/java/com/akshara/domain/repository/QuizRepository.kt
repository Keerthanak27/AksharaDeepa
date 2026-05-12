package com.akshara.domain.repository

import com.akshara.data.model.Question

object QuizRepository {
    fun getAllQuestions(): List<Question> {
        val questions = mutableListOf<Question>()

        // --- SCIENCE (Chapters 1-10) ---
        
        // 1. Chemical Reactions and Equations
        addQuestions(questions, 1, listOf(
            Triple("When magnesium ribbon is burnt in air, it produces a dazzling white flame and changes into a white powder called:", listOf("Magnesium oxide", "Magnesium hydroxide", "Magnesium carbonate", "Magnesium nitride"), 'A'),
            Triple("The reaction Fe2O3 + 2Al -> Al2O3 + 2Fe is an example of a:", listOf("Combination reaction", "Double displacement reaction", "Decomposition reaction", "Displacement reaction"), 'D'),
            Triple("Electrolysis of water is a decomposition reaction. The molar ratio of hydrogen and oxygen gases liberated during electrolysis of water is:", listOf("1:1", "2:1", "4:1", "1:2"), 'B'),
            Triple("Which of the following gases can be used for storage of fresh sample of an oil for a long time?", listOf("Carbon dioxide or oxygen", "Nitrogen or oxygen", "Carbon dioxide or helium", "Helium or nitrogen"), 'D'),
            Triple("Fatty foods become rancid due to the process of:", listOf("Oxidation", "Corrosion", "Reduction", "Hydrogenation"), 'A')
        ))

        // 2. Acids, Bases and Salts
        addQuestions(questions, 2, listOf(
            Triple("What is the pH of a neutral solution at 25°C?", listOf("0", "1", "7", "14"), 'C'),
            Triple("Nettle sting is a natural source of which acid?", listOf("Methanoic acid", "Lactic acid", "Citric acid", "Tartaric acid"), 'A'),
            Triple("The chemical formula of Plaster of Paris is:", listOf("CaSO4.2H2O", "CaSO4.1/2H2O", "CaSO4.H2O", "CaSO4"), 'B'),
            Triple("Sodium hydrogencarbonate (Baking Soda) on heating produces:", listOf("Sodium hydroxide", "Sodium carbonate", "Sodium oxide", "Sodium sulphate"), 'B'),
            Triple("Which of the following salts does not contain water of crystallisation?", listOf("Blue vitriol", "Baking soda", "Washing soda", "Gypsum"), 'B')
        ))

        // 3. Metals and Non-metals
        addQuestions(questions, 3, listOf(
            Triple("Which of the following is an amphoteric oxide?", listOf("Na2O", "MgO", "Al2O3", "K2O"), 'C'),
            Triple("The electronic configurations of three elements X, Y and Z are X — 2, 8; Y — 2, 8, 7 and Z — 2, 8, 2. Which of the following is correct?", listOf("X is a metal", "Y is a metal", "Z is a non-metal", "Y is a non-metal and Z is a metal"), 'D'),
            Triple("Metals are refined by using different methods. Which of the following metals are refined by electrolytic refining?", listOf("Au and Cu", "Na and K", "Fe and Al", "Cu and Zn"), 'A'),
            Triple("Galvanisation is a method of protecting iron from rusting by coating it with a thin layer of:", listOf("Gallium", "Aluminium", "Zinc", "Silver"), 'C'),
            Triple("Stainless steel is very useful material for our life. In stainless steel, iron is mixed with:", listOf("Ni and Cr", "Cu and Cr", "Ni and Cu", "Cu and Au"), 'A')
        ))

        // 4. Carbon and its Compounds
        addQuestions(questions, 4, listOf(
            Triple("Carbon exists in the atmosphere in the form of:", listOf("Carbon monoxide only", "Carbon monoxide in traces and carbon dioxide", "Carbon dioxide only", "Coal"), 'B'),
            Triple("The correct structural formula of ethyne is:", listOf("H-C≡C-H", "H3C-CH3", "H2C=CH2", "H-C≡C-CH3"), 'A'),
            Triple("Pentane has the molecular formula C5H12. It has:", listOf("5 covalent bonds", "12 covalent bonds", "16 covalent bonds", "17 covalent bonds"), 'C'),
            Triple("The functional group present in carboxylic acid is:", listOf("-OH", "-CHO", "-COOH", ">C=O"), 'C'),
            Triple("Ethanol reacts with sodium and forms two products. These are:", listOf("Sodium ethanoate and hydrogen", "Sodium ethanoate and oxygen", "Sodium ethoxide and hydrogen", "Sodium ethoxide and oxygen"), 'C')
        ))

        // 5. Life Processes
        addQuestions(questions, 5, listOf(
            Triple("Which of the following are energy foods?", listOf("Carbohydrates and fats", "Proteins and mineral salts", "Vitamins and minerals", "Water and roughage"), 'A'),
            Triple("In which part of the alimentary canal food is finally digested?", listOf("Stomach", "Mouth cavity", "Large intestine", "Small intestine"), 'D'),
            Triple("The internal (cellular) energy reserve in autotrophs is:", listOf("Glycogen", "Protein", "Starch", "Fatty acid"), 'C'),
            Triple("What prevents backflow of blood inside the heart during contraction?", listOf("Valves in heart", "Thick muscular walls of ventricles", "Thin walls of atria", "All of the above"), 'A'),
            Triple("The filtration units of kidneys are called:", listOf("Ureter", "Urethra", "Neurons", "Nephrons"), 'D')
        ))

        // 6. Control and Coordination
        addQuestions(questions, 6, listOf(
            Triple("Which plant hormone inhibits growth?", listOf("Auxin", "Cytokinin", "Gibberellin", "Abscisic acid"), 'D'),
            Triple("The main thinking part of the human brain is:", listOf("Forebrain", "Midbrain", "Hindbrain", "Spinal cord"), 'A'),
            Triple("A person with iodine deficiency is likely to suffer from:", listOf("Diabetes", "Goitre", "Dwarfism", "Gigantism"), 'B'),
            Triple("The movement of sunflower in accordance with the path of sun is due to:", listOf("Chemotropism", "Geotropism", "Phototropism", "Hydrotropism"), 'C'),
            Triple("Which of the following is an involuntary action?", listOf("Salivation", "Vomiting", "Heart beat", "All of the above"), 'D')
        ))

        // 7. How do Organisms Reproduce?
        addQuestions(questions, 7, listOf(
            Triple("In a flower, the parts that produce male and female gametes are:", listOf("Stamen and anther", "Filament and stigma", "Anther and ovary", "Stamen and style"), 'C'),
            Triple("The ability of an organism to design its body from a small piece is called:", listOf("Budding", "Fragmentation", "Regeneration", "Fission"), 'C'),
            Triple("In human females, an event that reflects onset of reproductive phase is:", listOf("Growth of body", "Change in voice", "Menstruation", "Increase in height"), 'C'),
            Triple("The seed contains the future plant in the form of:", listOf("Cotyledons", "Seed coat", "Embryo", "Endosperm"), 'C'),
            Triple("During adolescence, several changes occur in the human body. Mark one change associated with sexual maturation in boys:", listOf("Loss of milk teeth", "Increase in height", "Cracking of voice", "Weight gain"), 'C')
        ))

        // 8. Heredity and Evolution
        addQuestions(questions, 8, listOf(
            Triple("A Mendelian experiment consisted of breeding tall pea plants bearing violet flowers with short pea plants bearing white flowers. The progeny all bore violet flowers, but almost half of them were short. This suggests that the genetic make-up of the tall parent can be depicted as:", listOf("TTWW", "TTww", "TtWW", "TtWw"), 'C'),
            Triple("An example of homologous organs is:", listOf("Our arm and a dog's fore-leg", "Our teeth and an elephant's tusks", "Potato and runners of grass", "All of the above"), 'D'),
            Triple("The theory of natural selection was proposed by:", listOf("Gregor Mendel", "Charles Darwin", "Jean-Baptiste Lamarck", "Hugo de Vries"), 'B'),
            Triple("The sex of a child is determined by:", listOf("X chromosome from mother", "Y chromosome from father", "X chromosome from father", "Both B and C are correct"), 'D'),
            Triple("If a normal cell of human body contains 46 chromosomes, the number of chromosomes in a human egg cell will be:", listOf("46", "23", "92", "22"), 'B')
        ))

        // 9. Light - Reflection and Refraction
        addQuestions(questions, 9, listOf(
            Triple("A concave mirror gives real, inverted and same size image if the object is placed:", listOf("At F", "At C", "Between F and C", "Beyond C"), 'B'),
            Triple("Refractive index of glass with respect to air is 3/2. What is the refractive index of air with respect to glass?", listOf("2/3", "3/2", "1/2", "1/3"), 'A'),
            Triple("The power of a lens is 4.0 D. This indicates that the lens is:", listOf("Convex, f = 0.25 m", "Concave, f = 0.25 m", "Convex, f = 4 m", "Concave, f = 4 m"), 'A'),
            Triple("Where should an object be placed in front of a convex lens to get a real image of the size of the object?", listOf("At the principal focus", "At twice the focal length", "At infinity", "Between optical centre and focus"), 'B'),
            Triple("The unit of magnification is:", listOf("Metre", "Dioptre", "No unit", "Degree"), 'C')
        ))

        // 10. Human Eye and Colourful World
        addQuestions(questions, 10, listOf(
            Triple("The part of the eye that controls the amount of light entering is:", listOf("Retina", "Iris", "Cornea", "Ciliary muscles"), 'B'),
            Triple("Myopia can be corrected by using a:", listOf("Convex lens", "Concave lens", "Cylindrical lens", "Bifocal lens"), 'B'),
            Triple("The dangerous signal lights are red in color because red light is:", listOf("Scattered the most", "Scattered the least", "Absorbed the most", "Reflected the most"), 'B'),
            Triple("The formation of rainbow is due to:", listOf("Reflection, refraction and dispersion", "Only dispersion", "Only refraction", "Only total internal reflection"), 'A'),
            Triple("At noon the sun appears white as:", listOf("Light is least scattered", "All colors are scattered away", "Blue color is scattered the most", "Red color is scattered the most"), 'A')
        ))


        // --- MATHEMATICS (Chapters 11-20) ---

        // 11. Real Numbers
        addQuestions(questions, 11, listOf(
            Triple("If two positive integers a and b are written as a = x³y² and b = xy³; x, y are prime numbers, then HCF (a, b) is:", listOf("xy", "xy²", "x³y³", "x²y²"), 'B'),
            Triple("The decimal expansion of the rational number 14587/1250 will terminate after:", listOf("One decimal place", "Two decimal places", "Three decimal places", "Four decimal places"), 'D'),
            Triple("The HCF of 135 and 225 is:", listOf("15", "45", "75", "9"), 'B'),
            Triple("If HCF(306, 657) = 9, then LCM(306, 657) is:", listOf("22338", "23238", "33228", "22833"), 'A'),
            Triple("Which of the following is an irrational number?", listOf("2 + √4", "√2 + 3", "(√7)²", "0.121212..."), 'B')
        ))

        // 12. Polynomials
        addQuestions(questions, 12, listOf(
            Triple("If α and β are the zeroes of the polynomial x² - 5x + 6, then the value of α + β - αβ is:", listOf("-1", "11", "1", "0"), 'A'),
            Triple("The number of zeroes of the polynomial f(x) shown in the graph intersecting x-axis at 3 points is:", listOf("0", "1", "2", "3"), 'D'),
            Triple("A quadratic polynomial whose sum and product of zeroes are -3 and 2 respectively is:", listOf("x² - 3x + 2", "x² + 3x + 2", "x² + 2x - 3", "x² - 2x + 3"), 'B'),
            Triple("If one zero of the polynomial (k-1)x² + kx + 1 is -3, then the value of k is:", listOf("4/3", "-4/3", "2/3", "-2/3"), 'A'),
            Triple("Zeroes of p(z) = z² - 27 are:", listOf("±3√3", "±3", "±9", "±√3"), 'A')
        ))

        // 13. Pair of Linear Equations
        addQuestions(questions, 13, listOf(
            Triple("The pair of equations y = 0 and y = -7 has:", listOf("One solution", "Two solutions", "Infinitely many solutions", "No solution"), 'D'),
            Triple("If the lines given by 3x + 2ky = 2 and 2x + 5y + 1 = 0 are parallel, then the value of k is:", listOf("5/4", "2/5", "15/4", "3/2"), 'C'),
            Triple("For what value of k, do the equations 2x + 3y = 5 and 4x + ky = 10 have infinite solutions?", listOf("1", "3", "6", "0"), 'C'),
            Triple("Aruna has only Re 1 and Rs 2 coins with her. If the total number of coins she has is 50 and the amount of money with her is Rs 75, then the number of Re 1 and Rs 2 coins are, respectively:", listOf("35 and 15", "15 and 35", "25 and 25", "20 and 30"), 'C'),
            Triple("The sum of the digits of a two-digit number is 9. If 27 is added to it, the digits of the number get reversed. The number is:", listOf("25", "72", "36", "63"), 'C')
        ))

        // 14. Quadratic Equations
        addQuestions(questions, 14, listOf(
            Triple("Which of the following is a quadratic equation?", listOf("x² + 2x + 1 = (4-x)² + 3", "-2x² = (5-x)(2x - 2/5)", "(k+1)x² + 3/2x = 7 (where k = -1)", "x³ - x² = (x-1)³"), 'D'),
            Triple("The roots of the equation 2x² - x - 6 = 0 are:", listOf("-2, 3/2", "2, -3/2", "-2, -3/2", "2, 3/2"), 'B'),
            Triple("The discriminant of the quadratic equation 3x² - 2x + 1/3 = 0 is:", listOf("0", "1/3", "1", "3"), 'A'),
            Triple("If the equation x² + 4x + k = 0 has real and distinct roots, then:", listOf("k < 4", "k > 4", "k = 4", "k ≤ 4"), 'A'),
            Triple("The altitude of a right triangle is 7 cm less than its base. If the hypotenuse is 13 cm, the base is:", listOf("5 cm", "12 cm", "7 cm", "10 cm"), 'B')
        ))

        // 15. Arithmetic Progressions
        addQuestions(questions, 15, listOf(
            Triple("The common difference of the AP: 1/3, 5/3, 9/3, 13/3, ... is:", listOf("1", "4/3", "3/4", "2"), 'B'),
            Triple("The 30th term of the AP: 10, 7, 4, ... is:", listOf("87", "77", "-77", "-87"), 'C'),
            Triple("Which term of the AP: 21, 18, 15, ... is -81?", listOf("28th", "34th", "35th", "36th"), 'C'),
            Triple("The sum of first 22 terms of the AP: 8, 3, -2, ... is:", listOf("-979", "979", "-1000", "1000"), 'A'),
            Triple("The sum of first 100 positive integers is:", listOf("5050", "5000", "5100", "4950"), 'A')
        ))

        // 16. Triangles
        addQuestions(questions, 16, listOf(
            Triple("If in two triangles ABC and DEF, AB/DE = BC/FE = CA/FD, then:", listOf("ΔABC ~ ΔDEF", "ΔABC ~ ΔEDF", "ΔABC ~ ΔEFD", "ΔABC ~ ΔDFE"), 'B'),
            Triple("It is given that ΔABC ~ ΔDFE, ∠A = 30°, ∠C = 50°, AB = 5 cm, AC = 8 cm and DF = 7.5 cm. Then, which of the following is true?", listOf("DE = 12 cm, ∠F = 50°", "DE = 12 cm, ∠F = 100°", "EF = 12 cm, ∠D = 100°", "EF = 12 cm, ∠D = 30°"), 'B'),
            Triple("The areas of two similar triangles are in the ratio 25:64. The ratio of their corresponding sides is:", listOf("5:8", "25:64", "625:4096", "8:5"), 'A'),
            Triple("In ΔABC, AB = 6√3 cm, AC = 12 cm and BC = 6 cm. The angle B is:", listOf("120°", "60°", "90°", "45°"), 'C'),
            Triple("A vertical pole of length 6m casts a shadow 4m long on the ground and at the same time a tower casts a shadow 28m long. The height of the tower is:", listOf("40 m", "42 m", "38 m", "44 m"), 'B')
        ))

        // 17. Coordinate Geometry
        addQuestions(questions, 17, listOf(
            Triple("The coordinates of the point which divides the line segment joining (1, -2) and (4, 7) internally in the ratio 1:2 are:", listOf("(2, 1)", "(3, 3)", "(2, -1)", "(0, 0)"), 'A'),
            Triple("The distance of the point P (2, 3) from the y-axis is:", listOf("2", "3", "5", "1"), 'A'),
            Triple("If the distance between the points (x, -1) and (3, 2) is 5, then the value of x is:", listOf("-7 or 1", "7 or -1", "7 or 1", "0"), 'B'),
            Triple("The area of a triangle with vertices (2, 3), (-1, 0), (2, -4) is:", listOf("10.5", "21", "11.5", "12"), 'A'),
            Triple("The points (-4, 0), (4, 0), (0, 3) are the vertices of a:", listOf("Right triangle", "Isosceles triangle", "Equilateral triangle", "Scalene triangle"), 'B')
        ))

        // 18. Introduction to Trigonometry
        addQuestions(questions, 18, listOf(
            Triple("If sin A = 3/4, then cos A is:", listOf("√7/4", "4/3", "3/√7", "√7/3"), 'A'),
            Triple("The value of (sin 30° + cos 30°) - (sin 60° + cos 60°) is:", listOf("-1", "0", "1", "2"), 'B'),
            Triple("If tan A = 4/3, then sin A + cos A is:", listOf("7/3", "7/4", "7/5", "5/7"), 'C'),
            Triple("The value of (1 + tan²θ)(1 - sinθ)(1 + sinθ) is:", listOf("0", "1", "2", "sin²θ"), 'B'),
            Triple("If cos(40°+x) = sin 30°, then the value of x is:", listOf("10°", "20°", "30°", "40°"), 'B')
        ))

        // 19. Circles
        addQuestions(questions, 19, listOf(
            Triple("How many tangents can a circle have at a point on the circle?", listOf("One", "Two", "Infinite", "Zero"), 'A'),
            Triple("If TP and TQ are the two tangents to a circle with centre O so that ∠POQ = 110°, then ∠PTQ is equal to:", listOf("60°", "70°", "80°", "90°"), 'B'),
            Triple("The length of a tangent from a point A at distance 5 cm from the centre of the circle is 4 cm. The radius of the circle is:", listOf("3 cm", "√41 cm", "1 cm", "2 cm"), 'A'),
            Triple("If tangents PA and PB from a point P to a circle with centre O are inclined to each other at angle of 80°, then ∠POA is equal to:", listOf("50°", "60°", "70°", "80°"), 'A'),
            Triple("A line intersecting a circle in two points is called a:", listOf("Tangent", "Secant", "Chord", "Diameter"), 'B')
        ))

        // 20. Statistics
        addQuestions(questions, 20, listOf(
            Triple("The class mark of the class 10-25 is:", listOf("15", "17.5", "25", "35"), 'B'),
            Triple("For a given data, if Mean = 20 and Median = 22, then Mode is:", listOf("24", "26", "22", "20"), 'B'),
            Triple("The cumulative frequency table is useful in determining the:", listOf("Mean", "Median", "Mode", "Range"), 'B'),
            Triple("Construction of a cumulative frequency table is useful in determining the median. This is done using:", listOf("Histogram", "Ogive", "Frequency polygon", "Bar graph"), 'B'),
            Triple("If the mean of x, x+2, x+4, x+6, x+8 is 11, then the value of x is:", listOf("5", "7", "9", "11"), 'B')
        ))


        // --- SOCIAL STUDIES (Chapters 21-30) ---

        // 21. Rise of Nationalism in Europe
        addQuestions(questions, 21, listOf(
            Triple("Who were the 'Junkers'?", listOf("Soldiers", "Large landowners", "Aristocracy", "Weavers"), 'B'),
            Triple("The 'Young Italy' was founded by:", listOf("Garibaldi", "Mazzini", "Cavour", "Victor Emmanuel II"), 'B'),
            Triple("Which region was known as the 'powder keg' of Europe?", listOf("Germany", "Italy", "Balkans", "Ottoman Empire"), 'C'),
            Triple("The female allegory of the German nation is:", listOf("Germania", "Marianne", "Bharat Mata", "Britannia"), 'A'),
            Triple("Who followed the policy of 'Blood and Iron' for German unification?", listOf("Otto von Bismarck", "William I", "Mazzini", "Napoleon III"), 'A')
        ))

        // 22. Nationalism in India
        addQuestions(questions, 22, listOf(
            Triple("In which year did the Khilafat Movement start?", listOf("1919", "1920", "1921", "1922"), 'B'),
            Triple("Who formed the 'Swaraj Party' within the Congress?", listOf("Jawaharlal Nehru and Motilal Nehru", "C.R. Das and Motilal Nehru", "Gandhiji and C.R. Das", "Subhas Chandra Bose and Nehru"), 'B'),
            Triple("The resolution of 'Purna Swaraj' was adopted at which Congress session?", listOf("Calcutta", "Madras", "Lahore", "Nagpur"), 'C'),
            Triple("Who led the peasant movement in Awadh?", listOf("Baba Ramchandra", "Alluri Sitaram Raju", "Gandhiji", "Jawaharlal Nehru"), 'A'),
            Triple("Why was the Rowlatt Act called an 'oppressive' act?", listOf("It allowed detention of political prisoners without trial", "It increased taxes", "It banned public meetings", "It forced people into the army"), 'A')
        ))

        // 23. The Making of a Global World
        addQuestions(questions, 23, listOf(
            Triple("What was the main reason for the spread of Rinderpest in Africa?", listOf("Drought", "Infected cattle from British Asia", "Warfare", "Climate change"), 'B'),
            Triple("Which American city was known as the 'City of Gold' (El Dorado)?", listOf("New York", "Chicago", "Lima", "Fabled city of gold in South America"), 'D'),
            Triple("Who was the pioneer of mass production in the car industry?", listOf("Henry Ford", "James Watt", "Boulton", "James Hargreaves"), 'A'),
            Triple("Most Indian indentured workers came from which region?", listOf("Eastern UP and Bihar", "Punjab and Haryana", "Kerala and Tamil Nadu", "Maharashtra"), 'A'),
            Triple("The G-77 was a group of:", listOf("Developed countries", "Developing countries", "Communist countries", "Neutral countries"), 'B')
        ))

        // 24. The Age of Industrialization
        addQuestions(questions, 24, listOf(
            Triple("Which of the following was the first dynamic industry of Great Britain?", listOf("Cotton", "Iron and Steel", "Coal", "Shipbuilding"), 'A'),
            Triple("Why did industrialist in Victorian Britain prefer hand labor over machines?", listOf("Machines were expensive", "Seasonal demand for labor", "Range of products required hand skill", "All of the above"), 'D'),
            Triple("The Fly Shuttle was used for:", listOf("Spinning", "Weaving", "Cleaning cotton", "Dyeing"), 'B'),
            Triple("In 1911, 67% of large industries in India were located in:", listOf("Bengal and Bombay", "Madras and Punjab", "Bihar and Orissa", "Ahmedabad"), 'A'),
            Triple("Who were the 'Jobbers' in Indian factories?", listOf("Owners", "Laborers", "Intermediaries who brought new recruits", "Supervisors"), 'C')
        ))

        // 25. Resources and Development
        addQuestions(questions, 25, listOf(
            Triple("What is the main cause of land degradation in Punjab?", listOf("Intensive cultivation", "Deforestation", "Over-irrigation", "Overgrazing"), 'C'),
            Triple("Under which of the following type of resource can tidal energy be put?", listOf("Replenishable", "Human-made", "Abiotic", "Non-recyclable"), 'A'),
            Triple("Which of the following method is used to control soil erosion in hilly areas?", listOf("Terrace farming", "Strip cropping", "Shelter belts", "Overgrazing"), 'A'),
            Triple("The term 'Sustainable Development' was popularized by which report?", listOf("Brundtland Commission Report", "Rio Earth Summit", "Agenda 21", "Club of Rome"), 'A'),
            Triple("What is the percentage of desired forest area in India according to National Forest Policy (1952)?", listOf("21%", "25%", "33%", "40%"), 'C')
        ))

        // 26. Forest and Wildlife Resources
        addQuestions(questions, 26, listOf(
            Triple("In which state is the 'Sariska Tiger Reserve' located?", listOf("Rajasthan", "Madhya Pradesh", "Gujarat", "Uttarakhand"), 'A'),
            Triple("Which of the following is an extinct species?", listOf("Asiatic Cheetah", "Pink-headed duck", "Mountain Quail", "All of the above"), 'D'),
            Triple("Joint Forest Management (JFM) program was first started in which state?", listOf("Odisha", "West Bengal", "Bihar", "Gujarat"), 'A'),
            Triple("The Himalayan Yew is a:", listOf("Medicinal plant", "Timber tree", "Flowering plant", "Extinct animal"), 'A'),
            Triple("What is 'Jhumming'?", listOf("Plantation farming", "Shift cultivation", "Intensive farming", "Commercial farming"), 'B')
        ))

        // 27. Water Resources
        addQuestions(questions, 27, listOf(
            Triple("Which river is known as the 'Sorrow of Bengal'?", listOf("Ganga", "Damodar", "Kosi", "Hooghly"), 'B'),
            Triple("The 'Narmada Bachao Andolan' was led by:", listOf("Medha Patkar", "Sunderlal Bahuguna", "Baba Amte", "Anna Hazare"), 'A'),
            Triple("Which state has made rooftop rainwater harvesting structure compulsory for all houses?", listOf("Rajasthan", "Tamil Nadu", "Karnataka", "Meghalaya"), 'B'),
            Triple("Multi-purpose projects lead to:", listOf("Flood control", "Irrigation", "Electricity generation", "All of the above"), 'D'),
            Triple("What is 'Bamboo Drip Irrigation'?", listOf("Method of harvesting rain water", "Ancient system of tapping stream water", "Modern irrigation tool", "None of the above"), 'B')
        ))

        // 28. Agriculture
        addQuestions(questions, 28, listOf(
            Triple("What is 'Kripon' (Krip) in agriculture terminology in some regions?", listOf("A tool", "A crop", "A season", "A soil type"), 'A'),
            Triple("Which crop is known as the 'King of Pulses'?", listOf("Gram", "Arhar", "Moong", "Urad"), 'A'),
            Triple("Rabi crops are sown in:", listOf("Winter", "Monsoon", "Summer", "Spring"), 'A'),
            Triple("The 'White Revolution' is related to:", listOf("Rice", "Milk", "Cotton", "Eggs"), 'B'),
            Triple("India's rank in rubber production in the world is:", listOf("First", "Second", "Third", "Fourth"), 'D')
        ))

        // 29. Minerals and Energy Resources
        addQuestions(questions, 29, listOf(
            Triple("Which is the oldest oil-producing state in India?", listOf("Gujarat", "Maharashtra", "Assam", "Tamil Nadu"), 'C'),
            Triple("What is 'Magnetite'?", listOf("Highest quality iron ore", "Type of coal", "Non-metallic mineral", "Alloy"), 'A'),
            Triple("The 'Neyveli' lignite mines are located in:", listOf("Tamil Nadu", "Andhra Pradesh", "Kerala", "Karnataka"), 'A'),
            Triple("Bauxite is the ore of:", listOf("Iron", "Copper", "Aluminium", "Zinc"), 'C'),
            Triple("Where is the largest wind farm cluster located in India?", listOf("Rajasthan", "Tamil Nadu", "Gujarat", "Andhra Pradesh"), 'B')
        ))

        // 30. Manufacturing Industries
        addQuestions(questions, 30, listOf(
            Triple("Which industry is the 'Base Industry' of all other industries?", listOf("Textile", "Iron and Steel", "Chemical", "Automobile"), 'B'),
            Triple("Where was the first successful cotton textile mill established in India?", listOf("Ahmedabad", "Mumbai", "Kanpur", "Chennai"), 'B'),
            Triple("Which city is known as the 'Manchester of India'?", listOf("Mumbai", "Ahmedabad", "Surat", "Coimbatore"), 'B'),
            Triple("Which public sector plant was set up in collaboration with Russia?", listOf("Bhilai", "Rourkela", "Durgapur", "Salem"), 'A'),
            Triple("The 'Software Technology Parks of India' (STPI) provide:", listOf("Low cost hardware", "Single window service and high data communication", "Internet free of cost", "Free software"), 'B')
        ))

        return questions
    }

    private fun addQuestions(list: MutableList<Question>, chapterId: Int, data: List<Triple<String, List<String>, Char>>) {
        data.forEachIndexed { index, triple ->
            list.add(Question(
                id = (chapterId * 1000) + index,
                chapterId = chapterId,
                text = triple.first,
                optionA = triple.second[0],
                optionB = triple.second[1],
                optionC = triple.second[2],
                optionD = triple.second[3],
                correctOption = triple.third,
                explanation = "The correct answer is Option ${triple.third}. This is based on the 10th grade SSLC syllabus."
            ))
        }
    }
}
