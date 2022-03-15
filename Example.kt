fun someFunction() {
    // constructor like default progressDialog
    val progressbar = ProgressDialog(activity)
//         val dialog = activity.progressDialog(message = "progressing...").apply {
//             setCancelable(false)
//             show()
//         }
    doAsync {
       uiThread {
           // show dialog box
           progressbar.show()
           // set message about work
           progressbar.setTitle("progressing...")
       }



        // do something...



        uiThread {
//                         try {
//                             dialog.setMessage("기존 그룹에 데이터를 삭제합니다.")
//                         } catch (e: Throwable) {
//                             
//                         }
           progressbar.setTitle("기존 그룹의 데이터를 삭제합니다.")
        }



        // do something...



        uiThread {
//                                 dialog.max = c.count
          // setting max integer value to progress something
           progressbar.setMax(c.count)
        }



        // do something...



        uiThread {
//             dialog.progress = ++count
           // increasing of progress
           progressbar.setProgress(++count)
        }



        // do something...



        uiThread {
            isResult = false
            // dismiss progressbar after progress all work
            dialog.dismiss()
//                    progressbar.dismiss()
        }
    }
}
    
