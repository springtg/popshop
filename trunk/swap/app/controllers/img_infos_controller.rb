class ImgInfosController < ApplicationController
  # GET /img_infos
  # GET /img_infos.xml
  def index
    @img_infos = ImgInfo.find(:all)

    respond_to do |format|
      format.html # index.html.erb
      format.xml  { render :xml => @img_infos }
    end
  end

  # GET /img_infos/1
  # GET /img_infos/1.xml
  def show
    @img_info = ImgInfo.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.xml  { render :xml => @img_info }
    end
  end

  # GET /img_infos/new
  # GET /img_infos/new.xml
  def new
    @img_info = ImgInfo.new

    respond_to do |format|
      format.html # new.html.erb
      format.xml  { render :xml => @img_info }
    end
  end

  # GET /img_infos/1/edit
  def edit
    @img_info = ImgInfo.find(params[:id])
  end

  # POST /img_infos
  # POST /img_infos.xml
  def create
    @img_info = ImgInfo.new(params[:img_info])

    respond_to do |format|
      if @img_info.save
        flash[:notice] = 'ImgInfo was successfully created.'
        format.html { redirect_to(@img_info) }
        format.xml  { render :xml => @img_info, :status => :created, :location => @img_info }
      else
        format.html { render :action => "new" }
        format.xml  { render :xml => @img_info.errors, :status => :unprocessable_entity }
      end
    end
  end

  # PUT /img_infos/1
  # PUT /img_infos/1.xml
  def update
    @img_info = ImgInfo.find(params[:id])

    respond_to do |format|
      if @img_info.update_attributes(params[:img_info])
        flash[:notice] = 'ImgInfo was successfully updated.'
        format.html { redirect_to(@img_info) }
        format.xml  { head :ok }
      else
        format.html { render :action => "edit" }
        format.xml  { render :xml => @img_info.errors, :status => :unprocessable_entity }
      end
    end
  end

  # DELETE /img_infos/1
  # DELETE /img_infos/1.xml
  def destroy
    @img_info = ImgInfo.find(params[:id])
    @img_info.destroy

    respond_to do |format|
      format.html { redirect_to(img_infos_url) }
      format.xml  { head :ok }
    end
  end
end
