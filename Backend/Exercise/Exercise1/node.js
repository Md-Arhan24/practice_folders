//learnings - always try to convert the object or json format object to array by using Array.form method

const fs = require('fs')
const path = require('path')

// task:a file managet type which perform the task like if we given a folder path to it ,it will
//check the files it contains in it according to it extesions and create a folder according to extension
//{3 diff type ext = 3 diff type folder} and store them inside it(file)

// //steps : get the folder 
//           get all the files extension only once
//           create folder inside a parent folder according to extension
//           check the file and push the file to their appropiate folder.(dont copy ,cut the folder)
var set = new Set();
var location = __dirname;
fs.readdir(__dirname,'utf-8',(err,files) => {
    // console.log(__dirname);
    // console.log(path.extname(files.toString() + "\n"));
    // console.log(files.toString());
    var AllFiles = Array.from(files);
    // AllFiles.Map((file,index) => {
    //     console.log(path.extname(file));
    // })
   
    console.log(typeof(AllFiles));
    AllFiles.forEach((file,index) => {
        // console.log(path.extname(file));
        set.add(path.extname(file))
    })
    console.log(set);
    //makeing diff folders
    set.forEach((ele,i) => {
        var file = ele.split('.');
        var newFolder = __dirname + file[1].toUpperCase();
        fs.access(__dirname,(file,index) => {
            fs.mkdir(newFolder,{recursive:true},(err) => {
                if (err) throw err;
                // console.log("folders created successfully");
            })
        })
    })
    
    fs.readdir(__dirname,'utf-8',(err,f) => {
        var folder = Array.from(f);
        folder.forEach((fiile,_) => {
            var parentFolder = path.join(__dirname,"..");
            fs.readdir(parentFolder,'utf-8',(err,folder) => {
                var f2 = folder.slice(8);
                
            })
        })
    })

   
})
