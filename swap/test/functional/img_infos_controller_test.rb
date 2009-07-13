require 'test_helper'

class ImgInfosControllerTest < ActionController::TestCase
  def test_should_get_index
    get :index
    assert_response :success
    assert_not_nil assigns(:img_infos)
  end

  def test_should_get_new
    get :new
    assert_response :success
  end

  def test_should_create_img_info
    assert_difference('ImgInfo.count') do
      post :create, :img_info => { }
    end

    assert_redirected_to img_info_path(assigns(:img_info))
  end

  def test_should_show_img_info
    get :show, :id => img_infos(:one).id
    assert_response :success
  end

  def test_should_get_edit
    get :edit, :id => img_infos(:one).id
    assert_response :success
  end

  def test_should_update_img_info
    put :update, :id => img_infos(:one).id, :img_info => { }
    assert_redirected_to img_info_path(assigns(:img_info))
  end

  def test_should_destroy_img_info
    assert_difference('ImgInfo.count', -1) do
      delete :destroy, :id => img_infos(:one).id
    end

    assert_redirected_to img_infos_path
  end
end
