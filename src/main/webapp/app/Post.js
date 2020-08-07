//




// get all post
function getAllPosts() {
    fetch('/_ah/api/post/v1/postcollection')
    .then(response => response.json())
    .then(data => console.log(data));
}

// add post
function addPost(post) {
    return
}

// update post
function updatePost(post){
    return
}


 getAllPosts()