 <?xml version="1.0" encoding="utf-8"?>
<div id="tabsEx1"> 
     
        <input type="button" onclick="$('#tabsEx1 > ul').tabs('add', '#appended-tab', 'New Tab');" value="Add new tab"> 
        <input type="button" onclick="$('#tabsEx1 > ul').tabs('add', '#inserted-tab', 'New Tab', 1);" value="Insert tab"> 
        <input type="button" onclick="$('#tabsEx1 > ul').tabs('disable', 1);" value="Disable tab 2"> 
        <input type="button" onclick="$('#tabsEx1 > ul').tabs('enable', 1);" value="Enable tab 2"> 
        <input type="button" onclick="$('#tabsEx1 > ul').tabs('select', 2);" value="Select tab 3"> 
         
        <br><br> 
     
    <ul style="height: 30px;"> 
        <li><a href="#fragment-1"><span>One</span></a></li> 
        <li><a href="#fragment-2"><span>Two</span></a></li> 
        <li><a href="#fragment-3"><span>Three</span></a></li> 
    </ul> 
    <div id="fragment-1"> 
        <p>First tab is active by default</p> 
    </div> 
    <div id="fragment-2"> 
            <p><b>Second tab is active</b></p><br> 
      <p>Alternative ways to specify the active tab will overrule this argument, listed in the order of their precedence:</p><br> 
      <ol> 
          <li>If a fragment identifier (hash) in the URL of the page refers to the id of a tab panel of a tab interface the corresponding tab will become the initial tab.</li> 
          <li>Same if you use the cookie option to save the latest selected tab in.</li> 
          <li>Last not least you can set the selected tab by attaching the selected tab class 
          class (default: "ui-tabs-selected") to one of the <code>li</code> elements 
          representing a single tab.</li> 
      </ol> 
    </div> 
    <div id="fragment-3"> 
        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. 
        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. 
        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. 
    </div> 
</div>