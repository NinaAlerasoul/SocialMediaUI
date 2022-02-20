package com.example.socialuijp.model

object MockData {
    var storyList = ArrayList<Story>()
    var userList = ArrayList<User>()
    var postList = ArrayList<Post>()


    init {
        storyList.add(Story("taylor","https://images.wsj.net/im-213677?width=1280&size=1.77777778",true))
        storyList.add(Story("mehrad_hid","https://lastfm.freetls.fastly.net/i/u/770x0/c64b29b6c9cf4d46836b861c0e031178.jpg",false))
        storyList.add(Story("scarlett","https://stylesatlife.com/wp-content/uploads/2014/02/Scarlett-Johanssons-hair.jpg.webp",false))
        storyList.add(Story("kit_hari","https://upload.wikimedia.org/wikipedia/commons/7/7a/Kit_Harington.jpg",false))
        storyList.add(Story("kendall","https://i.pinimg.com/originals/7d/36/6e/7d366e11ddbf71e22acd09b528bf7a21.jpg",false))
        storyList.add(Story("shadmehr","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmnkNMzmHY8h_gARhSJ2zcESdEnsl8N1stDw&usqp=CAU",false))
        storyList.add(Story("emilia","https://buzzwonder.com/wp-content/uploads/2021/04/emiliaclarke-lede.jpg-1300x812-1.jpg",false))

        userList.add(User("mehrad_hid","https://lastfm.freetls.fastly.net/i/u/770x0/c64b29b6c9cf4d46836b861c0e031178.jpg", "Mehrad Hidden"))
        userList.add(User("taylor","https://images.wsj.net/im-213677?width=1280&size=1.77777778", "Taylor Swift"))
        userList.add(User("shadmehr","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmnkNMzmHY8h_gARhSJ2zcESdEnsl8N1stDw&usqp=CAU", "Shadmehr Aghili"))
        userList.add(User("kendall","https://i.pinimg.com/originals/7d/36/6e/7d366e11ddbf71e22acd09b528bf7a21.jpg", "Kendall Jenner"))
        userList.add(User("emilia","https://buzzwonder.com/wp-content/uploads/2021/04/emiliaclarke-lede.jpg-1300x812-1.jpg", "Emilia Clarke"))


        postList.add(Post(userList[1], "https://static01.nyt.com/images/2020/11/18/arts/16taylor-masters/merlin_179096598_efc4232d-7251-4c29-b1c3-b4c4fb4d22fb-mediumSquareAt3X.jpg", "New York", "It was the night things changed. Fearless is out now.Thank you guys"))
        postList.add(Post(userList[3], "https://content.api.news/v3/images/bin/1d3723689ca4a27270cab77c0dd94420", "Los Angeles", "The Met 2021!! wearing givenchyOfficial. Im obsessed with my team(Jenat and Marni)"))
        postList.add(Post(userList[4], "https://api.time.com/wp-content/uploads/2016/05/rts8haa.jpg", "Northern Ireland", "I am very sad about the end of this series and I miss all the guys! don't forget...winter is coming"))
        postList.add(Post(userList[0], "https://i1.sndcdn.com/artworks-8foVQaYXKeyVKZaF-5P37qw-t500x500.jpg", "Tehran, Iran", "Bozorg is coming soon... vaqan albume ajibie. Hatman gush konid va nazar bedid dustane aziz:) dousetun daram"))



    }
}