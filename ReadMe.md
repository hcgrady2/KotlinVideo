//https://www.cnblogs.com/webor2006/category/1668196.html

api



```
一、百度音乐api 01、首页 http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1

02、百度在线音乐歌单
    /**
     * #主打榜单
     * 1.新歌榜
     * 2.热歌榜
     * #分类榜单
     * 20.华语金曲榜
     * 21.欧美金曲榜
     * 24.影视金曲榜
     * 23.情歌对唱榜
     * 25.网络歌曲榜
     * 22.经典老歌榜
     * 11.摇滚榜
     * #媒体榜单
     * 6.KTV热歌榜
     * 8.Billboard
     * 18.Hito中文榜
     * 7.叱咤歌曲榜
     */
//热歌榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=2&size=3&offset=0

新歌榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=3&offset=0

华语金曲榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=20&size=3&offset=0

欧美金曲榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=21&size=3&offset=0

影视金曲榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=24&size=3&offset=0

情歌对唱榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=23&size=3&offset=0


网络歌曲榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=25&size=3&offset=0

摇滚榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=11&size=3&offset=0

KTV热歌榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=6&size=3&offset=0


Billboard
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=8&size=3&offset=0

Hito中文榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=18&size=3&offset=0

叱咤歌曲榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=7&size=3&offset=0

经典老歌榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=22&size=3&offset=0



03、歌曲榜单返回20条数据
热歌榜
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=2&size=20&offset=0


04、歌曲详情
获取歌曲播放url(成都)
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.play&songid=274841326

获取播放音乐url(桃花诺)
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.play&&songid=541680641
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.play&&songid=293272027


05、搜索歌曲
http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.search.catalogSug&&query=林俊杰



开源中国---百度音乐api
1、获取歌手专辑信息(第二步)
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.album.getAlbumInfo&format=json&album_id=11053974

2、搜索音乐
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.search.common&query=爱我还是他&page_size=30&page_no=1&format=json


3、获取歌手的所有歌曲(第四步)
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.artist.getSongList&format=json&tinguid=1432&offset=0&limits=30&order=2


4、排行榜
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=11&format=json



5、获取所有专辑(第一步)
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.album.getList&format=json&area=0&order=0&style=0&offset=0&limit=10&is_recommend=1



6、获取所有歌手列表 (第三步)
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.artist.getList&format=xml&offset=0&limit=500&area=1&order=1&sex=3&abc=0
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.radio.getCategoryList&format=xml
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.getInfo&format=json&songid=639512&bduss=unvalidbduss
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.radio.getChannelSong&channelid=3&pn=0&rn=50&format=json&key=34737226


7、获取歌手的专辑列表 (第二步)
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.artist.getAlbumList&format=json&tinguid=12894013&offset=0&limits=10&order=1


8、获取歌手信息
	http://http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.artist.getInfo&format=xml&tinguid=1157


9、歌词搜索 
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.search.lrcys&format=json&query=我的歌声里
	http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=2.4.0&method=baidu.ting.artist.get72HotArtist&format=json&order=1&offset=0&limit=50
	http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=2.4.0&method=baidu.ting.plaza.getPartDesc&format=json
	http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=2.4.0&method=baidu.ting.plaza.getFocusPic&format=json&limit=111

10、歌曲文件详细信息接口
	http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=2.4.0&method=baidu.ting.song.getInfos&format=json&songid=354387&ts=1354960702678&e=pOwOqqTY0fS5jmtSdOJBh4XW4rQHDI7EhrJgILD3Z%2FQ%3D&nw=1&bduss=



11、获取频道歌曲列表
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.radio.getChannelSong&format=json

12、获取专辑的歌曲列表 
	http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.radio.getArtistChannelSong&format=json

13、获取歌曲的详细信息(第三步)
	http://ting.baidu.com/data/music/links?songIds=歌曲id
	http://ting.baidu.com/data/music/links?songIds=540489965
```