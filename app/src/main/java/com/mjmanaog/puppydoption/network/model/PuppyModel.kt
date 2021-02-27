package com.mjmanaog.puppydoption.network.model

data class PuppyModel(
   val puppies: List<Puppy>
) {
    data class Puppy(
        val id: Int,
        val name: String,
        val gender: String,
        val breed: String,
        val dob: String,
        val weight: String,
        val imageURL: String,
        val vaccines: String,
        val personalities: String,
        val stories: String
    )
}

val puppyList = arrayListOf(
    PuppyModel.Puppy(
        1,
        "Lilo",
        "Female",
        "Golden Retriever",
        "12/16/2020",
        "4.65kg",
        "https://i.pinimg.com/564x/f1/f1/20/f1f120ece0b22290380af414fd105488.jpg",
        "Anti Rabies, 5in1, Bodetella",
        "Lilo is a sweet pup. She's sometimes shy but she loves to play with her siblings. She love cuddling with her toy Petra when she's asleep. Lovable and cute Golden Retriever.",
        "Lilo was rescued at a busy street in Manila. Luckily she's unharmed and healthy."
    ),
    PuppyModel.Puppy(
        2,
        "Cady",
        "Male",
        "Labrador",
        "1/10/2021",
        "7.65kg",
        "https://s3.amazonaws.com/filestore.rescuegroups.org/6685/pictures/animals/16437/16437662/76637913_500x500.jpg",
        "Anti Rabies, Fecalysis, Dewormed",
        "Cady is a sleepy pup. He spent her day sleeping but when he's awake he will directly play with his siblings. He love cuddling with his toy Diego, biting and playing around with him sometimes.Trustworthy and quiet Labrador.",
        "Cady was left by his furrmom when they needed to relocate for work."
    ),
    PuppyModel.Puppy(
        3,
        "Maxie",
        "Female",
        "Yorkshire",
        "11/22/2020",
        "6.65kg",
        "https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg",
        "Anti Rabies, 5in1, Dewormed",
        "Maxie is a very active small bean. She spent her day with zoomies but when she's tired doing zoomies she will lowkeyly petting her brother Edgar. She loves cuddling with her brother Diego, biting and playing around with him sometimes. Very fun and free spirited Yorkshire.",
        "Maxie was rescued by our team during the typhoon last year. We didn't know where her parents are."
    ),
    PuppyModel.Puppy(
        4,
        "Gustavo",
        "Male",
        "Husky",
        "10/19/2020",
        "8.65kg",
        "https://www.pdsa.org.uk/media/7895/husky-gallery-outdoors-4-min.jpg?anchor=center&mode=crop&quality=100&height=500&bgcolor=fff&rnd=132179622130000000",
        "Anti Rabies, 5in1, Dewormed",
        "Gustavo is a gentle doggo. He always spent his day taking care with his siblings. He likes being with his siblings at all times, he often plays with them and pet them. Very sweet and gentle Husky.",
        "Gustavo was left by his furrdad when they needed to relocate for work."
    ),
    PuppyModel.Puppy(
        5,
        "Edgar",
        "Male",
        "Pug",
        "12/16/2020",
        "4.65kg",
        "https://i.pinimg.com/564x/54/74/94/547494d55291e8f7fc9f1439697580fe.jpg",
        "Anti Rabies, 5in1, Bodetella",
        "Edgar is a sleepy pup. He spent her day sleeping but when he's awake he will directly play with his siblings. He love cuddling with his toy Diego, biting and playing around with him sometimes.Trustworthy and quiet Pug.",
        "Edgar was left by his furrmom when they needed to relocate for work."
    ),
    PuppyModel.Puppy(
        6,
        "Chonk",
        "Male",
        "Shiba inu",
        "12/16/2020",
        "4.65kg",
        "https://i.pinimg.com/originals/c0/24/39/c0243918240fe37ef20df063c5b79302.jpg",
        "Anti Rabies, Bodetella, Dewormed",
        "Chonk is a gentle doggo. He always spent his day taking care with his siblings. He likes being with his siblings at all times, he often plays with them and pet them. Very sweet and gentle Shiba Inu.",
        "Chonk was left by his furrdad when they needed to relocate for work."
    ),
    PuppyModel.Puppy(
        7,
        "Sammy",
        "Female",
        "Belgian Malinois",
        "12/16/2020",
        "8.22kg",
        "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2015/05/12214858/my-other-corvette-social-500x500.jpg",
        "Anti Rabies, 5in1, Dewormed",
        "Sammy is a very active small bean. She spent her day with zoomies but when she's tired doing zoomies she will lowkeyly petting her brother Edgar. She loves cuddling with her brother Diego, biting and playing around with him sometimes. Very fun and free spirited Belgian Malinois.",
        "Sammy was rescued by our team during the typhoon last year. We didn't know where her parents are."
    ),
    PuppyModel.Puppy(
        8,
        "Lettuce",
        "Male",
        "Chihuahua",
        "12/16/2020",
        "2.92kg",
        "https://i.redd.it/uo2zpzx2xoc21.jpg",
        "Anti Rabies, Fecalysis, Dewormed",
        "Lettuce is a sleepy pup. He spent her day sleeping but when he's awake he will directly play with his siblings. He love cuddling with his toy Diego, biting and playing around with him sometimes.Trustworthy and quiet Chihuahua.",
        "Lettuce was left by his furrdad when they needed to relocate for work."
    ),
    PuppyModel.Puppy(
        9,
        "Onion",
        "Female",
        "Shih Tzu",
        "12/16/2020",
        "3.62kg",
        "https://i.pinimg.com/564x/b3/72/b2/b372b2f17fcbe99ea0ef0f065d52286c.jpg",
        "Anti Rabies, 5in1, Dewormed",
        "Onion is a sweet pup. She's sometimes shy but she loves to play with her siblings. She love cuddling with her toy Petra when she's asleep. Lovable and cute Shih Tzu.",
        "Onion was rescued at a busy street in Manila. Luckily she's unharmed and healthy."
    ),
)