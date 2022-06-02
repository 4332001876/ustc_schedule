# USTC schedule 代码仓库

目前实现：导航栏、schedule、deadline、todolist布局的创建

待办：剩下的侧边栏、设置布局、功能

导航栏仍存在动画问题。

需要考虑`Databinding`替代`findViewById`方法。

`git clone`后最好不要直接在`main`分支里修改，可以考虑签出一个自己的分支，修改没有问题后再合并提交。

功能可以考虑使用`ViewModel`，`RecyclerView`等

日历部分仍需修改。

## 6.3 更新

目前添加了加入事件功能，但只有画面，没有保存。 
<!-- TODO -->

目前的考虑是点按`add_events`按钮后出现菜单，选择三种加入的方式，每种对应不同的全屏对话框。其中保存按钮位于`dialogs`包里的三个`dialog`内的`save_xxx`按钮的`onClick`方法下。

不过理想的情况是点按`add_events`按钮后出现一个全屏对话框，选择不同的类型，下方的需要填写的内容也对应变化。不过还没来得及实现，所以目前*只在`schedule_day`的画面中加入了菜单*。
