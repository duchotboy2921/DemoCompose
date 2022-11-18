package com.demo.nav

sealed class LoadingState(state:String){
    object Loading:LoadingState("loading")
    object DoneLoading:LoadingState("done_loading")
}
